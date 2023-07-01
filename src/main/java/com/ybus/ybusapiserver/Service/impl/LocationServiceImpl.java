package com.ybus.ybusapiserver.Service.impl;

import com.ybus.ybusapiserver.DTO.LocationInsertDTO;
import com.ybus.ybusapiserver.Factory.EntityFactory;
import com.ybus.ybusapiserver.JPA.Entity.bus.BusStop;
import com.ybus.ybusapiserver.JPA.Entity.bus.Device;
import com.ybus.ybusapiserver.JPA.Entity.bus.Location;
import com.ybus.ybusapiserver.JPA.repository.bus.BusStopRepository;
import com.ybus.ybusapiserver.JPA.repository.bus.DeviceRepository;
import com.ybus.ybusapiserver.JPA.repository.bus.LocationRepository;
import com.ybus.ybusapiserver.Service.LocationService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {
    private BusStopRepository busStopRepository;
    private DeviceRepository deviceRepository;
    private LocationRepository locationRepository;
    private EntityFactory entityFactory;

    @Autowired
    public LocationServiceImpl(BusStopRepository busStopRepository,
                               DeviceRepository deviceRepository,
                               LocationRepository locationRepository,
                               EntityFactory entityFactory){
        this.busStopRepository = busStopRepository;
        this.deviceRepository = deviceRepository;
        this.locationRepository = locationRepository;
        this.entityFactory = entityFactory;
    }
    @Override
    @Transactional
    public void insertLocationData(LocationInsertDTO locationInsertDTO){
        Device deviceInfo = deviceRepository.findDeviceToName(locationInsertDTO.getDevice_sn());

        Long busLineSeq = deviceInfo.getDeviceInfoSeq().getBusLine().getBusLineSeq();
        Long deviceSeq = deviceInfo.getDeviceSeq();

        BusStop lastBusStopInfo = locationRepository.findLastLocationInfo(deviceSeq).getBusStopSeq(); // 해당 기기의 마지막 정류장을 가져옴

        String lastBusStopLine = lastBusStopInfo.getBusStopLine();

        List<BusStop> busStopList = new ArrayList<BusStop>();

        if(lastBusStopLine.equals("turn")){ // 만약에 마지막 정류장이 회차 지점이었다면 쿼리파라미터를 down으로 해서 날리기
            busStopList = busStopRepository.findBusStopList(busLineSeq,"down"); // 마지막정류장이 상행인지 하행인지 보고 그에 따른 정류장 정보 가져오기. 회차지점은 항상 가져옴.
        }
        else{
            busStopList = busStopRepository.findBusStopList(busLineSeq,lastBusStopLine); // 마지막정류장이 상행인지 하행인지 보고 그에 따른 정류장 정보 가져오기. 회차지점은 항상 가져옴.
        }

        List<Distance> distances = busStopToDistance(locationInsertDTO,busStopList);
        distances = sortDistace(distances); //현재 위치와 가까운 순서대로 정렬된 버스정류장 클래스 리스트 회차 지잠도 포함함.



        if(distances.get(0).distance < Distance.gap){
            //isWithinRange를 1로 체크
            for(Distance now: distances){
                if(now.getBusStop().getBusStopOrder() < lastBusStopInfo.getBusStopOrder()){
                    continue; // 가장 가까운 정류장의 순서가 마지막 정류장의 순서보다 작다면 아무행동하지 않음. 다음으로 가까운 정류장의 위치를 파악해보는거임
                }
                else{
                    locationInsertDTO.setBusStopSeq(now.getBusStop().getBusStopSeq());
                    locationInsertDTO.setIsWithinRange(1);
                    break;
                }
            }
        }
        else{
            //isWithinRange를 0로 체크
//            for(Distance now: distances){
//                if(now.getBusStop().getBusStopOrder() < lastBusStopInfo.getBusStopOrder()){
//                    continue; // 가장 가까운 정류장의 순서가 마지막 정류장의 순서보다 작다면 아무행동하지 않음. 다음으로 가까운 정류장의 위치를 파악해보는거임
//                }
//                else{
//                    //삽입할 버스정류장의 정보를 now.getBusStop().getBusStopSeq()로 삽입함
//                    locationInsertDTO.setBusStopSeq(now.getBusStop().getBusStopSeq());
//                    locationInsertDTO.setIsWithinRange(0);
//                    break;
//                }
//            }
            locationInsertDTO.setBusStopSeq(lastBusStopInfo.getBusStopSeq());
            locationInsertDTO.setIsWithinRange(0);
        }

        locationInsertDTO.setDeviceSeq(deviceSeq);

        distances.forEach(name -> System.out.println(name.getDistance()));
        distances.forEach(name -> System.out.println(name.getBusStop().getBusStop()));

        System.out.println(lastBusStopInfo.getBusStop());

        System.out.println(locationInsertDTO.toString());

        Location location = entityFactory.locationToEntity(locationInsertDTO);

        locationRepository.save(location);
    }

    public static List<Distance> busStopToDistance(LocationInsertDTO locationInsertDTO,List<BusStop> busStopList){
        List<Distance> distances = new ArrayList<Distance>();
        for(BusStop busStop: busStopList){
            Distance distance = new Distance(locationInsertDTO.getLatitude(),locationInsertDTO.getLongitude(),busStop);
            distances.add(distance);
        }
        return distances;
    }

    public static class SizeComparator implements Comparator<Distance> {
        @Override
        public int compare(Distance obj1, Distance obj2) {
            return Double.compare(obj1.getDistance(), obj2.getDistance());
        }
    }
    public static List<Distance> sortDistace(List<Distance> distances){
        Collections.sort(distances, new SizeComparator());
//        distances.removeIf(e -> e.getDistance() > e.gap);
        return distances;
    }

    @Getter
    @Setter
    public static class Distance{
        private final double EARTH_RADIUS = 6371; // 지구의 반지름 (단위: km)
        private double latitude;
        private double longitude;
        private BusStop busStop;
        private double distance;
        public static double gap = 50;
        public Distance(double latitude, double longitude,BusStop busStop){
            this.latitude = latitude;
            this.longitude = longitude;
            this.busStop = busStop;
            this.distance();
        }
        public void distance(){

            // 위도와 경도를 라디안 값으로 변환
            double radLat1 = Math.toRadians(this.latitude);
            double radLon1 = Math.toRadians(this.longitude);
            double radLat2 = Math.toRadians(Double.parseDouble(busStop.getLatitude()));
            double radLon2 = Math.toRadians(Double.parseDouble(busStop.getLongitude()));

            // 위도와 경도의 차이 계산
            double deltaLat = radLat2 - radLat1;
            double deltaLon = radLon2 - radLon1;

            // Haversine 공식을 사용하여 거리 계산
            double a = Math.pow(Math.sin(deltaLat / 2), 2) + Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(deltaLon / 2), 2);
            double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
            double distance = EARTH_RADIUS * c * 1000;

            this.distance = distance;
        }
    }
}
