package com.ybus.ybusapiserver.Service.impl;

import com.ybus.ybusapiserver.DAO.BusLocationDAO;
import com.ybus.ybusapiserver.DTO.BusLocationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusLocationLogServiceImpl {
    private BusLocationDAO busLocationDAO;

    @Autowired
    public BusLocationLogServiceImpl(BusLocationDAO busLocationDAO){this.busLocationDAO = busLocationDAO;}

    public void busLocationLog(BusLocationDTO busLocationDTO){
        //버스의 기기번호와 버스 위치정보를 받음
        //정류장을 받아와야함.
    }
}
