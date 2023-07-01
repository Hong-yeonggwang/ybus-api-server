package com.ybus.ybusapiserver.JPA.QueryDslCustom;

import com.ybus.ybusapiserver.JPA.Entity.bus.BusStop;
import com.ybus.ybusapiserver.JPA.Entity.bus.DeviceInfo;

import java.util.List;

public interface DeviceInfoRepositoryCustom {
    public List<DeviceInfo> findBusStopList(String deviceName);
}
