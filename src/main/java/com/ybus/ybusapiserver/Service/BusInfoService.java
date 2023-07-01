package com.ybus.ybusapiserver.Service;

import com.ybus.ybusapiserver.DTO.BusLineDTO;
import com.ybus.ybusapiserver.DTO.BusScheduleDTO;
import com.ybus.ybusapiserver.DTO.BusStopDTO;
import com.ybus.ybusapiserver.DTO.BusTypeDTO;
import com.ybus.ybusapiserver.JPA.Entity.bus.BusSchedule;

import java.util.List;

public interface BusInfoService {
    void insertBusType(BusTypeDTO busTypeDTO);
    void insertBusLine(BusLineDTO busLineDTO);
    void insertBusStop(BusStopDTO busStopDTO);
    void insertBusSchedule(List<BusScheduleDTO> busScheduleDTO);

    String getBusSchedule(Long busLine,String weekDays);

    String getSchoolBusSchedule(String weekDays);

    String getBusLine(Long busTypeSeq);
}
