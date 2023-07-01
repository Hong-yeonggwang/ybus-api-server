package com.ybus.ybusapiserver.JPA.QueryDslCustom;


import com.ybus.ybusapiserver.JPA.Entity.bus.BusSchedule;

import java.util.List;

public interface BusScheduleRepositoryCustom {

    List<BusSchedule> getBusScheduleToLine(Long busLineSeq);

}
