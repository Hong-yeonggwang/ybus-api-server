package com.ybus.ybusapiserver.Service;


import com.ybus.ybusapiserver.DTO.BusLineDTO;
import com.ybus.ybusapiserver.DTO.BusStopDTO;
import com.ybus.ybusapiserver.DTO.BusTypeDTO;
import com.ybus.ybusapiserver.JPA.Entity.bus.BusLine;
import com.ybus.ybusapiserver.JPA.Entity.bus.BusStop;
import com.ybus.ybusapiserver.JPA.Entity.bus.BusType;
import com.ybus.ybusapiserver.JPA.repository.bus.BusLineRepository;
import com.ybus.ybusapiserver.JPA.repository.bus.BusStopRepository;
import com.ybus.ybusapiserver.JPA.repository.bus.BusTypeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BusInfoServiceTest {
    @Autowired
    private BusInfoService busInfoService;
    @Autowired
    private BusTypeRepository busTypeRepository;
    @Autowired
    private BusLineRepository busLineRepository;
    @Autowired
    private BusStopRepository busStopRepository;

    @Test
    public void insertBusTypeTest(){
        BusTypeDTO busTypeDTO =  new BusTypeDTO();
        busTypeDTO.setBusType("셔틀버스");
        busTypeDTO.setBusTypeState("show");

        busInfoService.insertBusType(busTypeDTO);
        List<BusType> busTypeList = busTypeRepository.findAll();
        busTypeList.forEach(name -> System.out.println(name.getBusType()));
    }
    @Test
    public void insertBusLineTest(){
        BusLineDTO busline = BusLineDTO.builder()
                .busLine("교내순환")
                .busLineState("show")
                .busTypeSeq(2L)
                .build();

        busInfoService.insertBusLine(busline);

        List<BusLine> busLineList = busLineRepository.findAll();
        busLineList.forEach(name -> System.out.println(name.toString()));
    }

    @Test
    public void insertBusStopTest(){
        BusStopDTO busStop = BusStopDTO.builder()
                .busStop("AI융합대 삼거리")
                .busStopLine("up")
                .busStopOrder(4)
                .latitude("37.227074254625165")
                .longitude("127.16687142848969")
                .busLineSeq(1L)
                .build();

        busInfoService.insertBusStop(busStop);

        List<BusStop> busStopList = busStopRepository.findAll();
        busStopList.forEach(name -> System.out.println(name.toString()));
    }
    @Test
    public void nProblem(){
        BusStop busLine = busStopRepository.getByBusStopSeq(1L);
        System.out.println(busLine.toString());
    }
}
