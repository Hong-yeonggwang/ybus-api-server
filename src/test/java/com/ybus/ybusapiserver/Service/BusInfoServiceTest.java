package com.ybus.ybusapiserver.Service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.ybus.ybusapiserver.DTO.BusLineDTO;
import com.ybus.ybusapiserver.DTO.BusStopDTO;
import com.ybus.ybusapiserver.DTO.BusTypeDTO;
import com.ybus.ybusapiserver.JPA.Entity.bus.BusLine;
import com.ybus.ybusapiserver.JPA.Entity.bus.BusSchedule;
import com.ybus.ybusapiserver.JPA.Entity.bus.BusStop;
import com.ybus.ybusapiserver.JPA.Entity.bus.BusType;
import com.ybus.ybusapiserver.JPA.repository.bus.BusLineRepository;
import com.ybus.ybusapiserver.JPA.repository.bus.BusScheduleRepository;
import com.ybus.ybusapiserver.JPA.repository.bus.BusStopRepository;
import com.ybus.ybusapiserver.JPA.repository.bus.BusTypeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
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
    @Autowired
    private BusScheduleRepository busScheduleRepository;

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
    @Transactional
    public void nProblem(){
        BusStop busLine = busStopRepository.getByBusStopSeq(1L);
        System.out.println("asd");
        System.out.println(busLine.getLocations().get(0));
    }
    @Test
    @Transactional
    public void queryDslBusLineTest(){
        List<BusLine> busLine = busLineRepository.findAllToDsl();
        busLine.forEach(name -> System.out.println(name.getBusTypeSeq()));
    }
    @Test
    @Transactional
    public void getBusScheduleTest(){
        List<BusSchedule> busScheduleList = busScheduleRepository.getBusScheduleToLine(1L);

//        busScheduleList.forEach(name -> System.out.println(name.getBusLineSeq().getBusTypeSeq().toString()));

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        try {
            // 리스트를 JSON으로 변환
            String busScheduleJson = objectMapper.writeValueAsString(busScheduleList);
            System.out.println(busScheduleJson);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
