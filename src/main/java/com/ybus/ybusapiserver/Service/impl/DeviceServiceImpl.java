package com.ybus.ybusapiserver.Service.impl;

import com.ybus.ybusapiserver.DAO.DeviceDAO;
import com.ybus.ybusapiserver.DTO.DeviceDTO;
import com.ybus.ybusapiserver.DTO.DeviceInfoDTO;
import com.ybus.ybusapiserver.Service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeviceServiceImpl implements DeviceService {
    private DeviceDAO deviceDAO;

    @Autowired
    public DeviceServiceImpl(DeviceDAO deviceDAO){this.deviceDAO = deviceDAO;}

    @Override
    public void insertDeviceData(DeviceDTO deviceDTO){
        deviceDAO.insertDeviceData(deviceDTO);
    }

    @Override
    public void insertDeviceInfoData(DeviceInfoDTO deviceInfoDTO){
        deviceDAO.insertDeviceInfoData(deviceInfoDTO);
    }
}
