package com.ybus.ybusapiserver.Controller;

import com.ybus.ybusapiserver.DTO.BusLineDTO;
import com.ybus.ybusapiserver.DTO.BusTypeDTO;
import com.ybus.ybusapiserver.Service.BusInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bus")
public class BusInfoController {
    private BusInfoService busInfoService;
    @Autowired
    public BusInfoController(BusInfoService busInfoService){this.busInfoService = busInfoService;}

    @PostMapping("/busType")
    public void insertBustype(BusTypeDTO busTypeDTO){
        busInfoService.insertBusType(busTypeDTO);
    }
    @PostMapping("/busLine")
    public void insertBusLine(BusLineDTO busLineDTO){
        busInfoService.insertBusLine(busLineDTO);
    }

}
