package com.ybus.ybusapiserver.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ybus.ybusapiserver.Config.JwtProvider;
import com.ybus.ybusapiserver.DTO.BusLineDTO;
import com.ybus.ybusapiserver.DTO.BusTypeDTO;
import com.ybus.ybusapiserver.DTO.LocationInsertDTO;
import com.ybus.ybusapiserver.Service.BusInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Collections;

@RestController
@RequestMapping("/bus")
public class BusInfoController {
    private BusInfoService busInfoService;

    @Autowired
    private JwtProvider jwtProvider;
    @Autowired
    public BusInfoController(BusInfoService busInfoService){this.busInfoService = busInfoService;}

    @PostMapping(value ="/busType")
    public void insertBustype(@RequestBody BusTypeDTO busTypeDTO){
        busInfoService.insertBusType(busTypeDTO);
    }
    @PostMapping(value ="/busLine")
    public void insertBusLine(@RequestBody BusLineDTO busLineDTO){
        busInfoService.insertBusLine(busLineDTO);
    }
    @GetMapping(value = "/request")
    public String helloWorld(@RequestParam String hello){
        return hello;
    }
    @GetMapping(value = "/token")
    public String helloWorld(){
        String name = "yeonggwang";
        List<String> role = Collections.singletonList("ADMIN");
        String hello = jwtProvider.createToken(name , role);
        return hello;
    }
}
