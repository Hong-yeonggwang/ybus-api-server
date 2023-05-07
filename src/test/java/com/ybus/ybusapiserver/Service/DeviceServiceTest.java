package com.ybus.ybusapiserver.Service;


import com.ybus.ybusapiserver.DTO.DeviceDTO;
import com.ybus.ybusapiserver.JPA.Entity.bus.Device;
import com.ybus.ybusapiserver.JPA.Entity.bus.Location;
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

}
