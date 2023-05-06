package com.ybus.ybusapiserver.Service;

import com.ybus.ybusapiserver.DTO.BusLineDTO;
import com.ybus.ybusapiserver.DTO.BusStopDTO;
import com.ybus.ybusapiserver.DTO.BusTypeDTO;

public interface BusInfoService {
    public void insertBusType(BusTypeDTO busTypeDTO);
    public void insertBusLine(BusLineDTO busLineDTO);
    public void insertBusStop(BusStopDTO busStopDTO);
}
