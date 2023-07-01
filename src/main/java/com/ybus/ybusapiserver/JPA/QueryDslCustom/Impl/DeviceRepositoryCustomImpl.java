package com.ybus.ybusapiserver.JPA.QueryDslCustom.Impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ybus.ybusapiserver.JPA.Entity.bus.BusStop;
import com.ybus.ybusapiserver.JPA.Entity.bus.Device;
import com.ybus.ybusapiserver.JPA.QueryDslCustom.DeviceRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

import static com.ybus.ybusapiserver.JPA.Entity.bus.QDevice.device;

@Repository
public class DeviceRepositoryCustomImpl implements DeviceRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    public DeviceRepositoryCustomImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public Device findDeviceToName(String deviceName) {
        return queryFactory.selectFrom(device)
                .leftJoin(device.deviceInfoSeq)
                .fetchJoin()
                .where(device.deviceName.eq(deviceName))
                .fetchOne();
    }
}
