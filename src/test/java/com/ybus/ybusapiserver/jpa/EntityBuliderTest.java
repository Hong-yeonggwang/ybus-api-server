package com.ybus.ybusapiserver.jpa;

import com.ybus.ybusapiserver.JPA.Entity.bus.BusStop;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class EntityBuliderTest {

    @Test
    void entityBuliderTest() {
        BusStop busStop = BusStop.builder()
                .busStop("용인대입구")
                .build();

        System.out.println(busStop.getBusStop());
        System.out.println(busStop.toString());
    }

}
