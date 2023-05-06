package com.ybus.ybusapiserver.Service.impl;

import com.ybus.ybusapiserver.DAO.BusLineDAO;
import com.ybus.ybusapiserver.DAO.BusStopDAO;
import com.ybus.ybusapiserver.DAO.BusTypeDAO;
import com.ybus.ybusapiserver.DTO.BusLineDTO;
import com.ybus.ybusapiserver.DTO.BusStopDTO;
import com.ybus.ybusapiserver.DTO.BusTypeDTO;
import com.ybus.ybusapiserver.Service.BusInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusInfoServiceImpl implements BusInfoService {
    private BusTypeDAO busTypeDAO;
    private BusLineDAO busLineDAO;
    private BusStopDAO busStopDAO;
    @Autowired
    public BusInfoServiceImpl(BusTypeDAO busTypeDAO ,
                              BusLineDAO busLineDAO,
                              BusStopDAO busStopDAO){
        this.busTypeDAO = busTypeDAO;
        this.busLineDAO = busLineDAO;
        this.busStopDAO = busStopDAO;
    }
    @Override
    public void insertBusType(BusTypeDTO busTypeDTO){
        busTypeDAO.insertBusTypeInfo(busTypeDTO);
    }
    @Override
    public void insertBusLine(BusLineDTO busLineDTO){
        busLineDAO.insertBusLine(busLineDTO);
    }
    @Override
    public void insertBusStop(BusStopDTO busStopDTO){
        busStopDAO.insertBusStop(busStopDTO);
    }
}
