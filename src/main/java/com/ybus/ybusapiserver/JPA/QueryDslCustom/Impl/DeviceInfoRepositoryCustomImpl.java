package com.ybus.ybusapiserver.JPA.QueryDslCustom.Impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ybus.ybusapiserver.JPA.Entity.bus.BusStop;
import com.ybus.ybusapiserver.JPA.Entity.bus.DeviceInfo;
import com.ybus.ybusapiserver.JPA.QueryDslCustom.DeviceInfoRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

import static com.ybus.ybusapiserver.JPA.Entity.bus.QBusStop.busStop1;

@Repository
public class DeviceInfoRepositoryCustomImpl implements DeviceInfoRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    public DeviceInfoRepositoryCustomImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<DeviceInfo> findBusStopList(String deviceName) {
        return null;
    }

}
