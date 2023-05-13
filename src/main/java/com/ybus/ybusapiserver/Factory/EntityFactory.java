package com.ybus.ybusapiserver.Factory;

import com.ybus.ybusapiserver.DTO.BusLineDTO;
import com.ybus.ybusapiserver.DTO.BusStopDTO;
import com.ybus.ybusapiserver.DTO.DeviceInfoDTO;
import com.ybus.ybusapiserver.JPA.Entity.bus.*;
import com.ybus.ybusapiserver.JPA.repository.bus.BusTypeRepository;
import com.ybus.ybusapiserver.JPA.repository.bus.BusLineRepository;
import com.ybus.ybusapiserver.JPA.repository.bus.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EntityFactory {
    private BusTypeRepository busTypeRepository;
    private BusLineRepository busLineRepository;
    private DeviceRepository deviceRepository;
    @Autowired
    public EntityFactory(BusTypeRepository busTypeRepository,
                         BusLineRepository busLineRepository,
                         DeviceRepository deviceRepository){
        this.busTypeRepository = busTypeRepository;
        this.busLineRepository = busLineRepository;
        this.deviceRepository = deviceRepository;
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

    public DeviceInfo deviceInfoToEntity(DeviceInfoDTO deviceInfoDTO){
        BusLine busLine = busLineRepository.getByBusLineSeq(deviceInfoDTO.getBusLine());
        BusType busType = busTypeRepository.getByBusTypeSeq(deviceInfoDTO.getBusType());
        Device device = deviceRepository.getByDeviceSeq(deviceInfoDTO.getDeviceSeq());
        DeviceInfo deviceInfo = DeviceInfo.builder()
                .deviceRegdate(deviceInfoDTO.getDeviceRegdate())
                .deviceState(deviceInfoDTO.getDeviceState())
                .deviceSeq(device)
                .busNumber(deviceInfoDTO.getBusNumber())
                .busAlias(deviceInfoDTO.getBusAlias())
                .busType(busType)
                .busLine(busLine)
                .build();
        return deviceInfo;
    }
}
