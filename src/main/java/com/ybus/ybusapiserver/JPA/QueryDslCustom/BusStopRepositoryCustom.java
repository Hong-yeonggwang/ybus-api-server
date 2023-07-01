package com.ybus.ybusapiserver.JPA.QueryDslCustom;

import com.ybus.ybusapiserver.JPA.Entity.bus.BusStop;
import org.springframework.data.jpa.repository.EntityGraph;

import java.util.List;

public interface BusStopRepositoryCustom {
    List<BusStop> findBusStopList(Long busLineSeq,String busStopLine);
}
