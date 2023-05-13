package com.ybus.ybusapiserver.DAO.Impl;

import com.ybus.ybusapiserver.DAO.DeviceDAO;
import com.ybus.ybusapiserver.DTO.DeviceDTO;
import com.ybus.ybusapiserver.DTO.DeviceInfoDTO;
import com.ybus.ybusapiserver.Factory.EntityFactory;
import com.ybus.ybusapiserver.JPA.Entity.bus.Device;
import com.ybus.ybusapiserver.JPA.Entity.bus.DeviceInfo;
import com.ybus.ybusapiserver.JPA.repository.bus.DeviceInfoRepository;
import com.ybus.ybusapiserver.JPA.repository.bus.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeviceDAOImpl implements DeviceDAO {

    private DeviceRepository deviceRepository;
    private DeviceInfoRepository deviceInfoRepository;
    private EntityFactory entityFactory;
    @Autowired
    public DeviceDAOImpl(DeviceRepository deviceRepository,
                         DeviceInfoRepository deviceInfoRepository,
                         EntityFactory entityFactory){
        this.deviceRepository = deviceRepository;
        this.deviceInfoRepository = deviceInfoRepository;
        this.entityFactory = entityFactory;
    }

    @Override
    public void insertDeviceData(DeviceDTO deviceDTO){
        Device device = deviceDTO.toEntity();
        deviceRepository.save(device);
        deviceRepository.flush();
    }
    @Override
    public void insertDeviceInfoData(DeviceInfoDTO deviceInfoDTO){
        DeviceInfo deviceInfo = entityFactory.deviceInfoToEntity(deviceInfoDTO);
        deviceInfoRepository.save(deviceInfo);
        deviceInfoRepository.flush();
    }
}
