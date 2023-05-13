package com.ybus.ybusapiserver.DAO;

import com.ybus.ybusapiserver.DTO.DeviceDTO;
import com.ybus.ybusapiserver.DTO.DeviceInfoDTO;

public interface DeviceDAO {
    void insertDeviceData(DeviceDTO deviceDTO);
    void insertDeviceInfoData(DeviceInfoDTO deviceInfoDTO);
}
