package com.ybus.ybusapiserver.Controller;

import com.ybus.ybusapiserver.DTO.BusLineDTO;
import com.ybus.ybusapiserver.DTO.BusScheduleDTO;
import com.ybus.ybusapiserver.DTO.BusTypeDTO;
import com.ybus.ybusapiserver.Service.BusInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private BusInfoService busInfoService;
    @Autowired
    public AdminController(BusInfoService busInfoService){this.busInfoService = busInfoService;}

    @PostMapping(value ="/busType")
    public void insertBusType(@RequestBody BusTypeDTO busTypeDTO){
        busInfoService.insertBusType(busTypeDTO);
    }
    @PostMapping(value ="/busLine")
    public void insertBusLine(@RequestBody BusLineDTO busLineDTO){
        busInfoService.insertBusLine(busLineDTO);
    }
    @PostMapping(value = "/schedule")
    public void insertBusSchedule(@RequestBody List<BusScheduleDTO> busScheduleDTO){
        busInfoService.insertBusSchedule(busScheduleDTO);
    }

}
