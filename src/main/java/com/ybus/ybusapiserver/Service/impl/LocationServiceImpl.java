package com.ybus.ybusapiserver.Service.impl;

import com.ybus.ybusapiserver.DTO.LocationInsertDTO;
import com.ybus.ybusapiserver.JPA.Entity.bus.BusStop;
import com.ybus.ybusapiserver.JPA.repository.bus.BusStopRepository;
import com.ybus.ybusapiserver.Service.LocationService;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {
    private BusStopRepository busStopRepository;

    @Autowired
    public LocationServiceImpl(BusStopRepository busStopRepository){
        this.busStopRepository = busStopRepository;
    }
    @Override
    public void insertLocationData(LocationInsertDTO locationInsertDTO){
        int lastBusStop;
        List<BusStop> busStopList = busStopRepository.findAll();
        System.out.println("1차 쿼리");

        List<Distance> distances = busStopToDistance(locationInsertDTO,busStopList);
        distances = sortDistace(distances);

        distances.forEach(name -> System.out.println(name.toString()));

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
        return distances;
    }

    @Getter
    @Setter
    @ToString
    public static class Distance{
        private final double EARTH_RADIUS = 6371; // 지구의 반지름 (단위: km)
        private double latitude;
        private double longitude;
        private BusStop busStop;
        private double distance;
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
