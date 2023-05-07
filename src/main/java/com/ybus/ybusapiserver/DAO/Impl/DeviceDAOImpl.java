package com.ybus.ybusapiserver.DAO.Impl;

import com.ybus.ybusapiserver.DAO.DeviceDAO;
import com.ybus.ybusapiserver.DTO.DeviceDTO;
import com.ybus.ybusapiserver.JPA.Entity.bus.Device;
import com.ybus.ybusapiserver.JPA.repository.bus.DeviceInfoRepository;
import com.ybus.ybusapiserver.JPA.repository.bus.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeviceDAOImpl implements DeviceDAO {

    private DeviceRepository deviceRepository;
    private DeviceInfoRepository deviceInfoRepository;
    @Autowired
    public DeviceDAOImpl(DeviceRepository deviceRepository,
                         DeviceInfoRepository deviceInfoRepository){
        this.deviceRepository = deviceRepository;
        this.deviceInfoRepository = deviceInfoRepository;
    }

    @Override
    public void insertDeviceData(DeviceDTO deviceDTO){
        Device device = deviceDTO.toEntity();
        deviceRepository.save(device);
        deviceRepository.flush();
    }
    @Override
    public void insertDeviceInfoData(){

    }
}
