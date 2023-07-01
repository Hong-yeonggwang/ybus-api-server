package com.ybus.ybusapiserver.JPA.QueryDslCustom.Impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ybus.ybusapiserver.JPA.Entity.bus.BusLine;
import com.ybus.ybusapiserver.JPA.Entity.bus.BusStop;
import com.ybus.ybusapiserver.JPA.QueryDslCustom.BusStopRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

import static com.ybus.ybusapiserver.JPA.Entity.bus.QBusLine.busLine1;
import static com.ybus.ybusapiserver.JPA.Entity.bus.QBusStop.busStop1;

@Repository
public class BusStopRepositoryCustomImpl implements BusStopRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public BusStopRepositoryCustomImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<BusStop> findBusStopList(Long busLineSeq , String busStopLine) {
        return queryFactory.selectFrom(busStop1)
                .leftJoin(busStop1.busLineSeq)
                .fetchJoin()
                .where(busStop1.busLineSeq.busLineSeq.eq(busLineSeq).and(busStop1.busStopLine.eq(busStopLine).or(busStop1.busStopLine.eq("turn"))))
                .fetch();
    }

}
