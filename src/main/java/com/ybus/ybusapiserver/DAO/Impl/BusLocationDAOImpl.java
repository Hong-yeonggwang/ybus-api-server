package com.ybus.ybusapiserver.DAO.Impl;

import com.ybus.ybusapiserver.DAO.BusLocationDAO;
import com.ybus.ybusapiserver.JPA.repository.bus.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BusLocationDAOImpl implements BusLocationDAO {
    private LocationRepository locationRepository;
    @Autowired
    public BusLocationDAOImpl(LocationRepository locationRepository){
        this.locationRepository = locationRepository;
    }

    @Override
    public void insertLocationLog(){


    }
}
