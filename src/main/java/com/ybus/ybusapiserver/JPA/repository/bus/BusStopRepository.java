package com.ybus.ybusapiserver.JPA.repository.bus;

import com.ybus.ybusapiserver.JPA.Entity.bus.BusStop;
import com.ybus.ybusapiserver.JPA.Entity.bus.Device;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BusStopRepository extends JpaRepository<BusStop,Long> {
    BusStop getByBusStopSeq(Long busStopSeq);

    @Override
    @EntityGraph(attributePaths = {"locations"})
    List<BusStop> findAll();
}
