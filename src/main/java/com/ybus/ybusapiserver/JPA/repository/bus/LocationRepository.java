package com.ybus.ybusapiserver.JPA.repository.bus;

import com.ybus.ybusapiserver.JPA.Entity.bus.Location;
import com.ybus.ybusapiserver.JPA.QueryDslCustom.LocationRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location,Long> , LocationRepositoryCustom {

    @Query(value = "select * from location where busstopseq is not null and LOCATIONTIME > DATE_FORMAT(DATE_ADD(now(),INTERVAL -5 MINUTE),'%Y-%m-%d %H:%i:%s')\n" +
            "group by deviceseq ORDER BY locationtime DESC LIMIT 0,500", nativeQuery = true)
    List<Location> searchLocation();
}
