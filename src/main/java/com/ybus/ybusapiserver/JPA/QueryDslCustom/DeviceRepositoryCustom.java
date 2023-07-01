package com.ybus.ybusapiserver.JPA.QueryDslCustom;

import com.ybus.ybusapiserver.JPA.Entity.bus.Device;

public interface DeviceRepositoryCustom {
    public Device findDeviceToName(String DeviceName);
}
