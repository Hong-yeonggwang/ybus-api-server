package com.ybus.ybusapiserver.Controller;

import com.ybus.ybusapiserver.DTO.BusLineDTO;
import com.ybus.ybusapiserver.DTO.BusScheduleDTO;
import com.ybus.ybusapiserver.DTO.BusTypeDTO;
import com.ybus.ybusapiserver.Service.BusInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Collections;

@RestController
@RequestMapping("/bus")
public class BusInfoController {
    private BusInfoService busInfoService;

    @Autowired
    public BusInfoController(BusInfoService busInfoService){this.busInfoService = busInfoService;}

    @GetMapping(value = "/schedule")
    public String getBusSchedule(@RequestParam("busline") Long busLine,@RequestParam("weekDays") String weekDays){
        String busScheduleList = busInfoService.getBusSchedule(busLine,weekDays);
        return busScheduleList;
    }
    @GetMapping(value = "/schedule/school")
    public String getSchoolBusSchedule(@RequestParam("weekDays") String weekDays){
        String busScheduleList = busInfoService.getSchoolBusSchedule(weekDays);
        return busScheduleList;
    }

    @GetMapping(value = "/busLine")
    public String getBusLine(@RequestParam("busline") Long busLine){
        String busLineList = busInfoService.getBusLine(busLine);
        return busLineList;
    }
}

