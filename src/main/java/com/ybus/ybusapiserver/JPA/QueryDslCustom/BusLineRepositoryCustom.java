package com.ybus.ybusapiserver.JPA.QueryDslCustom;

import com.ybus.ybusapiserver.JPA.Entity.bus.BusLine;

import java.util.List;

public interface BusLineRepositoryCustom {
    public List<BusLine> findAllToDsl();
}
