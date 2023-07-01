package com.ybus.ybusapiserver.Service;

import com.ybus.ybusapiserver.DTO.LocationInsertDTO;
import com.ybus.ybusapiserver.Service.impl.LocationServiceImpl;
import org.hibernate.loader.Loader;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LocationServiceTest {
    @Autowired
    LocationService locationService;
    @Test
    public void insetLocationTest(){
        LocationInsertDTO dto = LocationInsertDTO.builder()
                .device_sn("노랭 2호차")
                .location_date(1683619300L)
                .longitude(127.1912d)
                .latitude(37.2357d)
                .member_key("0b24ce3248df84d3b4a737cc7ccc58f82b9930e3")
                .build();
        locationService.insertLocationData(dto);
    }
}
