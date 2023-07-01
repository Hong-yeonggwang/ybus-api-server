package com.ybus.ybusapiserver.JPA.QueryDslCustom.Impl;

import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ybus.ybusapiserver.DTO.LocationRecentDTO;
import com.ybus.ybusapiserver.JPA.Entity.bus.Location;
import com.ybus.ybusapiserver.JPA.Entity.bus.QLocation;
import com.ybus.ybusapiserver.JPA.QueryDslCustom.LocationRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import java.util.List;

import static com.ybus.ybusapiserver.JPA.Entity.bus.QLocation.location;

@Repository
public class LocationRepositoryCustomImpl implements LocationRepositoryCustom {

    private final JPAQueryFactory queryFactory;
    private final EntityManager em;

    public LocationRepositoryCustomImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
        this.em = em;
    }


    @Override
    public Location findLastLocationInfo(Long deviceSeq){
        QLocation subQueryLocation = new QLocation("subQueryLocation");

        return queryFactory.selectFrom(location)
                .where(location.deviceSeq.deviceSeq.eq(deviceSeq)
                .and(location.locationTime.eq(
                        JPAExpressions.select(subQueryLocation.locationTime.max())
                                .from(subQueryLocation)
                                .where(subQueryLocation.deviceSeq.deviceSeq.eq(deviceSeq))
                )))
                .fetchFirst();
    }

    @Override
    public void test(){

        String sql = "select A.* from location A right outer join \n" +
                "(select max(X.locationtime) as maxtime,X.deviceseq as deviceseqs from location X join \n" +
                "(select device.deviceseq as deviceseq,device.devicename as devicename,deviceinfo.devicestate as devicestate  from device join deviceinfo on device.deviceinfoseq = deviceinfo.deviceinfoseq where devicestate = ?) Y on Y.deviceseq = X.deviceseq\n" +
                "group by X.deviceseq)B on A.locationtime = b.maxtime;";

        Query nativeQuery = em.createNativeQuery(sql,"locationRecentDTO").setParameter(1,"show");

        List<LocationRecentDTO> resultList = nativeQuery.getResultList();

        resultList.forEach(name -> System.out.println(name.toString()));

    }

}
