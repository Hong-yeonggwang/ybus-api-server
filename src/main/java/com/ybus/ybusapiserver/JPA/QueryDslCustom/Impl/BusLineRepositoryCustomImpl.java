package com.ybus.ybusapiserver.JPA.QueryDslCustom.Impl;

import static com.ybus.ybusapiserver.JPA.Entity.bus.QBusLine.busLine1;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ybus.ybusapiserver.JPA.Entity.bus.BusLine;
import com.ybus.ybusapiserver.JPA.QueryDslCustom.BusLineRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class BusLineRepositoryCustomImpl implements BusLineRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public BusLineRepositoryCustomImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<BusLine> findAllToDsl() {
        return queryFactory.selectFrom(busLine1)
                .innerJoin(busLine1.busTypeSeq)
                .fetchJoin()
                .fetch();
    }

}
