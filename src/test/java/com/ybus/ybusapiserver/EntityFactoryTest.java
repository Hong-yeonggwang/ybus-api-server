package com.ybus.ybusapiserver;

import com.ybus.ybusapiserver.DTO.BusLineDTO;
import com.ybus.ybusapiserver.Factory.EntityFactory;
import com.ybus.ybusapiserver.JPA.Entity.bus.BusLine;
import com.ybus.ybusapiserver.JPA.Entity.bus.BusType;
import com.ybus.ybusapiserver.JPA.repository.bus.BusTypeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EntityFactoryTest {

    @Autowired
    private EntityFactory entityFactory;
    @Autowired
    private BusTypeRepository busTypeRepository;
    @Test
    public void toEntity(){
        BusLineDTO busLineDTO = BusLineDTO.builder()
                .busLine("교내순환").busLineState("show").busTypeSeq(2L)
                .build();
        BusLine busLine = entityFactory.busLinetoEntity(busLineDTO);
        System.out.println(busLine.toString());
    }


}
