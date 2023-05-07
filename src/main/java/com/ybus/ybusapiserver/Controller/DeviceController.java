package com.ybus.ybusapiserver.Controller;

import com.ybus.ybusapiserver.DTO.DeviceDTO;
import com.ybus.ybusapiserver.Service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/device")
public class DeviceController {
    private DeviceService deviceService;
    @Autowired
    public DeviceController(DeviceService deviceService){this.deviceService = deviceService;}

    @PostMapping("/busLine")
    public void insertDeviceData(DeviceDTO deviceDTO){
        deviceService.insertDeviceData(deviceDTO);
    }

}
