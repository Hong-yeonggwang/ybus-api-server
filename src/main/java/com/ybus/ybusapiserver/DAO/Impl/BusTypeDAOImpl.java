package com.ybus.ybusapiserver.DAO.Impl;

import com.ybus.ybusapiserver.DAO.BusTypeDAO;
import com.ybus.ybusapiserver.DTO.BusTypeDTO;
import com.ybus.ybusapiserver.JPA.Entity.bus.BusType;
import com.ybus.ybusapiserver.JPA.repository.bus.BusTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BusTypeDAOImpl implements BusTypeDAO {
    private BusTypeRepository busTypeRepository;

    @Autowired
    public BusTypeDAOImpl(BusTypeRepository busTypeRepository){this.busTypeRepository = busTypeRepository;}
    @Override
    public void insertBusTypeInfo(BusTypeDTO busTypeDTO){
        BusType busType = busTypeDTO.toEntity();
        busTypeRepository.save(busType);
        busTypeRepository.flush();
    }
}
