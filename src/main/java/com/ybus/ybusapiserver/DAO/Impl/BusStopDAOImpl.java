package com.ybus.ybusapiserver.DAO.Impl;

import com.ybus.ybusapiserver.DAO.BusStopDAO;
import com.ybus.ybusapiserver.DTO.BusStopDTO;
import com.ybus.ybusapiserver.Factory.EntityFactory;
import com.ybus.ybusapiserver.JPA.Entity.bus.BusStop;
import com.ybus.ybusapiserver.JPA.repository.bus.BusStopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.text.html.parser.Entity;

@Component
public class BusStopDAOImpl implements BusStopDAO {
    private BusStopRepository busStopRepository;
    private EntityFactory entityFactory;

    @Autowired
    public BusStopDAOImpl(BusStopRepository busStopRepository,
                          EntityFactory entityFactory){
        this.busStopRepository = busStopRepository;
        this.entityFactory = entityFactory;
    }
    @Override
    public void insertBusStop(BusStopDTO busStopDTO) {
        BusStop busStop = entityFactory.busStopToEntity(busStopDTO);
        busStopRepository.save(busStop);
        busStopRepository.flush();
    }
}
