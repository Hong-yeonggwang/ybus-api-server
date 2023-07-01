package com.ybus.ybusapiserver.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ybus.ybusapiserver.DTO.LocationInsertDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gper")
public class LocationController {

    @PostMapping(value = "/location")
    public String helloWorld(@RequestBody String deviceLocationData){
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(deviceLocationData);
            JsonNode dataNode = rootNode.get("data");

            LocationInsertDTO locationInsetDTO = LocationInsertDTO.builder()
                    .device_sn(dataNode.get("device_sn").asText())
                    .member_key(dataNode.get("member_key").asText())
                    .location_date(dataNode.get("location_date").asLong())
                    .latitude(dataNode.get("latitude").asDouble())
                    .longitude(dataNode.get("longitude").asDouble())
                    .build();
            return locationInsetDTO.toString();

        }catch (JsonProcessingException e) {
            e.printStackTrace();
            return e.toString();
        }
    }
}
