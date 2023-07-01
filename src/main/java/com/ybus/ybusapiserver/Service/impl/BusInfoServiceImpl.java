package com.ybus.ybusapiserver.Service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.ybus.ybusapiserver.DAO.BusInfoDAO;
import com.ybus.ybusapiserver.DTO.BusLineDTO;
import com.ybus.ybusapiserver.DTO.BusScheduleDTO;
import com.ybus.ybusapiserver.DTO.BusStopDTO;
import com.ybus.ybusapiserver.DTO.BusTypeDTO;
import com.ybus.ybusapiserver.DTO.ReturnDTO.ScheduleDTO;
import com.ybus.ybusapiserver.DTO.ReturnDTO.ScheduleSchoolDTO;
import com.ybus.ybusapiserver.JPA.Entity.bus.BusLine;
import com.ybus.ybusapiserver.JPA.Entity.bus.BusSchedule;
import com.ybus.ybusapiserver.Service.BusInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusInfoServiceImpl implements BusInfoService {
    private BusInfoDAO busInfoDAO;
    @Autowired
    public BusInfoServiceImpl(BusInfoDAO busInfoDAO){
        this.busInfoDAO = busInfoDAO;
    }
    @Override
    public void insertBusType(BusTypeDTO busTypeDTO){
        busInfoDAO.insertBusTypeInfo(busTypeDTO);
    }
    @Override
    public void insertBusLine(BusLineDTO busLineDTO){
        busInfoDAO.insertBusLine(busLineDTO);
    }
    @Override
    public void insertBusStop(BusStopDTO busStopDTO){
        busInfoDAO.insertBusStop(busStopDTO);
    }

    @Override
    public void insertBusSchedule(List<BusScheduleDTO> busScheduleDTO){
        busInfoDAO.insertBusSchedule(busScheduleDTO);
    }

    @Override
    public String getBusSchedule(Long busLine,String weekDays){
        List<ScheduleDTO> busScheduleList = busInfoDAO.getBusSchedule(busLine,weekDays);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        try {
            // 리스트를 JSON으로 변환
            String busScheduleJson = objectMapper.writeValueAsString(busScheduleList);
            return busScheduleJson;
        } catch (Exception e) {
            e.printStackTrace();
            return "joson parsing Error";
        }
    }

    @Override
    public String getSchoolBusSchedule(String weekDays) {
        List<ScheduleSchoolDTO> scheduleList = busInfoDAO.getSchoolBusSchedule(weekDays);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        try {
            // 리스트를 JSON으로 변환
            String scheduleJson = objectMapper.writeValueAsString(scheduleList);
            return scheduleJson;
        } catch (Exception e) {
            e.printStackTrace();
            return "joson parsing Error";
        }
    }

    @Override
    public String getBusLine(Long busTypeSeq) {

        List<BusLine> busLines = busInfoDAO.getByBusType(busTypeSeq);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        try {
            // 리스트를 JSON으로 변환
            String busLineJson = objectMapper.writeValueAsString(busLines);
            return busLineJson;
        } catch (Exception e) {
            e.printStackTrace();
            return "joson parsing Error";
        }
    }
}
