package com.ybus.ybusapiserver.DAO;

import com.ybus.ybusapiserver.DTO.DeviceDTO;

public interface DeviceDAO {
    void insertDeviceData(DeviceDTO deviceDTO);
    void insertDeviceInfoData();
}
