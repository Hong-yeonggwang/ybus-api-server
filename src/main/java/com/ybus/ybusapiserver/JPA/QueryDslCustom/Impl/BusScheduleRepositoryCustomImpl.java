package com.ybus.ybusapiserver.JPA.QueryDslCustom.Impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ybus.ybusapiserver.JPA.Entity.bus.BusLine;
import com.ybus.ybusapiserver.JPA.Entity.bus.BusSchedule;
import com.ybus.ybusapiserver.JPA.QueryDslCustom.BusScheduleRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

import static com.ybus.ybusapiserver.JPA.Entity.bus.QBusSchedule.busSchedule;
import static com.ybus.ybusapiserver.JPA.Entity.bus.QBusLine.busLine1;


@Repository
public class BusScheduleRepositoryCustomImpl implements BusScheduleRepositoryCustom {

    private final JPAQueryFactory queryFactory;
    private final EntityManager em;

    public BusScheduleRepositoryCustomImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
        this.em = em;
    }

    @Override
    public List<BusSchedule> getBusScheduleToLine(Long busLineSeq) {

        String jpql = "SELECT bs FROM BusSchedule bs " +
                "JOIN FETCH bs.busLineSeq bl " +
                "JOIN FETCH bl.busTypeSeq " +
                "WHERE bs.busLineSeq.busLineSeq = :busLineSeq";

        List<BusSchedule> busSchedules = em
                .createQuery(jpql, BusSchedule.class)
                .setParameter("busLineSeq", busLineSeq)
                .getResultList();
        return busSchedules;
    }

}
