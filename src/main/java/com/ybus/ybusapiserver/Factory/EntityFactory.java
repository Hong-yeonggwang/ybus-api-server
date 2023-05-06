package com.ybus.ybusapiserver.Factory;

import com.ybus.ybusapiserver.DTO.BusLineDTO;
import com.ybus.ybusapiserver.DTO.BusStopDTO;
import com.ybus.ybusapiserver.JPA.Entity.bus.BusLine;
import com.ybus.ybusapiserver.JPA.Entity.bus.BusStop;
import com.ybus.ybusapiserver.JPA.Entity.bus.BusType;
import com.ybus.ybusapiserver.JPA.repository.bus.BusTypeRepository;
import com.ybus.ybusapiserver.JPA.repository.bus.BusLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EntityFactory {
    private BusTypeRepository busTypeRepository;
    private BusLineRepository busLineRepository;
    @Autowired
    public EntityFactory(BusTypeRepository busTypeRepository,
                         BusLineRepository busLineRepository){
        this.busTypeRepository = busTypeRepository;
        this.busLineRepository = busLineRepository;
    }

    public BusLine busLinetoEntity(BusLineDTO busLineDTO){
        BusType busType = busTypeRepository.getByBusTypeSeq(busLineDTO.getBusTypeSeq());
        BusLine busLine = BusLine.builder()
                .busLine(busLineDTO.getBusLine())
                .busLineState(busLineDTO.getBusLineState())
                .busTypeSeq(busType)
                .build();
        return busLine;
    }

    public BusStop busStopToEntity(BusStopDTO busStopDTO){
        BusLine busLine = busLineRepository.getByBusLineSeq(busStopDTO.getBusLineSeq());
        BusStop busStop = BusStop.builder()
                .busStop(busStopDTO.getBusStop())
                .busStopLine(busStopDTO.getBusStopLine())
                .busStopOrder(busStopDTO.getBusStopOrder())
                .latitude(busStopDTO.getLatitude())
                .longitude(busStopDTO.getLongitude())
                .busLineSeq(busLine)
                .build();
        return busStop;
    }
}
