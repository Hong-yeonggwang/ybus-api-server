package com.ybus.ybusapiserver.JPA.repository.bus;

import com.ybus.ybusapiserver.JPA.Entity.bus.BusLine;
import com.ybus.ybusapiserver.JPA.QueryDslCustom.BusLineRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BusLineRepository extends JpaRepository<BusLine,Long> , BusLineRepositoryCustom {

    @Query("SELECT e FROM BusLine e JOIN FETCH e.busTypeSeq WHERE e.busTypeSeq.busTypeSeq = :busTypeSeq AND e.busLineState = 'show'")
    List<BusLine> getByBusTypeAndState(@Param("busTypeSeq") Long busTypeSeq);
}
