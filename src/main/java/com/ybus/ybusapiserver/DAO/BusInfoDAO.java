package com.ybus.ybusapiserver.DAO;

import com.ybus.ybusapiserver.DTO.BusLineDTO;
import com.ybus.ybusapiserver.DTO.BusScheduleDTO;
import com.ybus.ybusapiserver.DTO.BusStopDTO;
import com.ybus.ybusapiserver.DTO.BusTypeDTO;
import com.ybus.ybusapiserver.DTO.ReturnDTO.ScheduleDTO;
import com.ybus.ybusapiserver.DTO.ReturnDTO.ScheduleSchoolDTO;
import com.ybus.ybusapiserver.JPA.Entity.bus.BusLine;
import com.ybus.ybusapiserver.JPA.Entity.bus.BusSchedule;

import java.util.List;

public interface BusInfoDAO {
    void insertBusTypeInfo(BusTypeDTO busTypeDTO);
    void insertBusLine(BusLineDTO busLineDTO);
    void insertBusStop(BusStopDTO busStopDTO);
    void insertBusSchedule(List<BusScheduleDTO> busScheduleDTO);
    List<ScheduleDTO> getBusSchedule(Long busLineSeq, String weekDays);
    List<ScheduleSchoolDTO> getSchoolBusSchedule(String weekDays);

    List<BusLine> getByBusType(Long busTypeSeq);


}
