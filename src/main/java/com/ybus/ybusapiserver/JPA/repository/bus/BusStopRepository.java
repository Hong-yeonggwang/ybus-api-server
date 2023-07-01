package com.ybus.ybusapiserver.JPA.repository.bus;

import com.ybus.ybusapiserver.JPA.Entity.bus.BusStop;
import com.ybus.ybusapiserver.JPA.Entity.bus.Device;
import com.ybus.ybusapiserver.JPA.QueryDslCustom.BusStopRepositoryCustom;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BusStopRepository extends JpaRepository<BusStop,Long> , BusStopRepositoryCustom  {
    BusStop getByBusStopSeq(Long busStopSeq);

    @Override
    @EntityGraph(attributePaths = {"locations"})
    List<BusStop> findAll();

    List<BusStop> getBusStopsByBusLineSeq(BusStop BusLineSeq);
}
