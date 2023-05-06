package com.ybus.ybusapiserver.JPA.repository.bus;

import com.ybus.ybusapiserver.JPA.Entity.bus.BusLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusLineRepository extends JpaRepository<BusLine,Long> {
    BusLine getByBusLineSeq(Long busLineSeq);
}
