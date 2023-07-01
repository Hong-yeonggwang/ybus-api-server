package com.ybus.ybusapiserver.JPA.QueryDslCustom;

import com.ybus.ybusapiserver.JPA.Entity.bus.Location;

public interface LocationRepositoryCustom {
    Location findLastLocationInfo(Long deviceSeq);
    void test();
}
