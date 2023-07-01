package com.ybus.ybusapiserver.jpa;

import com.ybus.ybusapiserver.JPA.Entity.admin.Admin;
import com.ybus.ybusapiserver.JPA.Entity.bus.*;
import com.ybus.ybusapiserver.JPA.repository.admin.AdminRepository;
import com.ybus.ybusapiserver.JPA.repository.bus.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
class EntityBuliderTest {

    @Autowired
    BusStopRepository busStopRepository;
    @Autowired
    BusScheduleRepository busScheduleRepository;
    @Autowired
    DeviceInfoRepository deviceInfoRepository;
    @Autowired
    DeviceRepository deviceRepository;
    @Autowired
    LocationRepository locationRepository;
    @Autowired
    AdminRepository adminRepository;
    @Test
    void entityBuliderTest() {
        BusStop busStop = BusStop.builder()
                .busStop("용인대입구")
                .build();

        System.out.println(busStop.getBusStop());
        System.out.println(busStop.toString());
    }

    @Test
    void getBusStopsBuBusLineSeq(){
        Device device = deviceRepository.getByDeviceSeq(1L);
        System.out.println("asd");
        DeviceInfo deviceInfo = deviceInfoRepository.getDeviceInfoByDeviceSeq(device);
//        List<BusStop> busStopList = busStopRepository.getBusStopsByBusLineSeq(device);

//        busStopList.forEach(name -> System.out.println(name.getBusStop()));
        System.out.println(deviceInfo.getBusNumber());
    }

    @Test
    @Transactional
    public void qclassTest(){
//        List<BusStop> busStopList = busStopRepository.findBusStopList(2L);
//        busStopList.forEach(name -> System.out.println(name.getBusStopSeq()));

//        Device device = deviceRepository.findBusLineToDeviceName("노랭 2호차");
//        System.out.println(device.getDeviceInfoSeq().getDeviceInfoSeq());


        Long busLineSeq = deviceRepository.findDeviceToName("노랭 2호차").getDeviceInfoSeq().getBusLine().getBusLineSeq();
        System.out.println(busLineSeq);
        List<BusStop> busStopList = busStopRepository.findBusStopList(busLineSeq,"up");

        busStopList.forEach(name ->System.out.println(name.getBusStop()));
    }

    @Test
    @Transactional
    public void joinTest(){
        List<BusSchedule> busScheduleList = busScheduleRepository.getBusScheduleToLine(1L);
        busScheduleList.forEach(name -> System.out.println(name.getBusTime()));
    }

}
