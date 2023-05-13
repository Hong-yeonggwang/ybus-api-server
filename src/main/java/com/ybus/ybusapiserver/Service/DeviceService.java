package com.ybus.ybusapiserver.Service;

import com.ybus.ybusapiserver.DTO.DeviceDTO;
import com.ybus.ybusapiserver.DTO.DeviceInfoDTO;

public interface DeviceService {
    void insertDeviceData(DeviceDTO deviceDTO);
    void insertDeviceInfoData(DeviceInfoDTO deviceInfoDTO);
}
