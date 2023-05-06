package com.ybus.ybusapiserver.DAO.Impl;

import com.ybus.ybusapiserver.DAO.BusLineDAO;
import com.ybus.ybusapiserver.DTO.BusLineDTO;
import com.ybus.ybusapiserver.Factory.EntityFactory;
import com.ybus.ybusapiserver.JPA.Entity.bus.BusLine;
import com.ybus.ybusapiserver.JPA.repository.bus.BusLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BusLineDAOImpl implements BusLineDAO {
    private BusLineRepository busLineRepository;
    private EntityFactory entityFactory;
    @Autowired
    public BusLineDAOImpl(BusLineRepository busLineRepository ,
                          EntityFactory entityFactory){
        this.busLineRepository = busLineRepository;
        this.entityFactory = entityFactory;
    }
    @Override
    public void insertBusLine(BusLineDTO busLineDTO){
        BusLine busLine = entityFactory.busLinetoEntity(busLineDTO);
        busLineRepository.save(busLine);
        busLineRepository.flush();
    }
}
