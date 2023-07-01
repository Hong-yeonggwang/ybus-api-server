package com.ybus.ybusapiserver.jpa.repositroy.board;

import com.ybus.ybusapiserver.DTO.BusScheduleDTO;
import com.ybus.ybusapiserver.DTO.ReturnDTO.ScheduleDTO;
import com.ybus.ybusapiserver.JPA.Entity.bus.BusLine;
import com.ybus.ybusapiserver.JPA.repository.bus.BusLineRepository;
import com.ybus.ybusapiserver.JPA.repository.bus.BusScheduleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class JpaRepositroyTest {
    @Autowired
    private BusLineRepository busLineRepository;

    @Test
    public void busLineFindTest(){
        List<BusLine> busLineList = busLineRepository.getByBusTypeAndState(1L);

        busLineList.forEach(name->System.out.println(name.toString()));
    }
}
