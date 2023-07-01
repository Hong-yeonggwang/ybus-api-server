package com.ybus.ybusapiserver.Service;


import com.ybus.ybusapiserver.DTO.DeviceDTO;
import com.ybus.ybusapiserver.DTO.DeviceInfoDTO;
import com.ybus.ybusapiserver.JPA.Entity.bus.Device;
import com.ybus.ybusapiserver.JPA.Entity.bus.DeviceInfo;
import com.ybus.ybusapiserver.JPA.repository.bus.DeviceInfoRepository;
import com.ybus.ybusapiserver.JPA.repository.bus.DeviceRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class DeviceServiceTest {
    @Autowired
    private DeviceService deviceService;
    @Autowired
    private DeviceRepository deviceRepository;
    @Autowired
    private DeviceInfoRepository deviceInfoRepository;

    @Test
    public void insertDeviceTest(){
        DeviceDTO device = DeviceDTO.builder()
                .deviceHashKey("testDeviceHashKey")
                .deviceName("노랭 2호차")
                .updateTime(LocalDateTime.now())
                .build();
        deviceService.insertDeviceData(device);

        List<Device> devices = deviceRepository.findAll();
        devices.forEach(name -> System.out.println(name.getLocations()));

        for(Device a : devices){
            System.out.println(a.getLocations().get(0).getDeviceSeq());
        }
    }
    @Test
    public void insertDeviceInfoTest(){
//        DeviceInfoDTO deviceInfoDTO = DeviceInfoDTO.builder()
//                .deviceRegdate(LocalDateTime.now())
//                .deviceState("show")
//                .busNumber("123테스트 4567")
//                .busAlias("테스트 노랭이 2호")
//                .busType(1L)
//                .busLine(1L)
//                .build();
//
//        deviceService.insertDeviceInfoData(deviceInfoDTO);

        List<DeviceInfo> devices = deviceInfoRepository.findAll();
        devices.forEach(name -> System.out.println(name.getBusType()));
    }
}
