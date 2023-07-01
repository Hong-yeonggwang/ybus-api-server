package com.ybus.ybusapiserver.DAO.Impl;

import com.ybus.ybusapiserver.DAO.BusInfoDAO;
import com.ybus.ybusapiserver.DTO.BusLineDTO;
import com.ybus.ybusapiserver.DTO.BusScheduleDTO;
import com.ybus.ybusapiserver.DTO.BusStopDTO;
import com.ybus.ybusapiserver.DTO.BusTypeDTO;
import com.ybus.ybusapiserver.DTO.ReturnDTO.ScheduleDTO;
import com.ybus.ybusapiserver.DTO.ReturnDTO.ScheduleSchoolDTO;
import com.ybus.ybusapiserver.Factory.EntityFactory;
import com.ybus.ybusapiserver.JPA.Entity.bus.BusLine;
import com.ybus.ybusapiserver.JPA.Entity.bus.BusSchedule;
import com.ybus.ybusapiserver.JPA.Entity.bus.BusStop;
import com.ybus.ybusapiserver.JPA.Entity.bus.BusType;
import com.ybus.ybusapiserver.JPA.repository.bus.BusLineRepository;
import com.ybus.ybusapiserver.JPA.repository.bus.BusScheduleRepository;
import com.ybus.ybusapiserver.JPA.repository.bus.BusStopRepository;
import com.ybus.ybusapiserver.JPA.repository.bus.BusTypeRepository;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Component
public class BusInfoDAOImpl  implements BusInfoDAO {
    private BusLineRepository busLineRepository;
    private BusStopRepository busStopRepository;
    private BusTypeRepository busTypeRepository;
    private BusScheduleRepository busScheduleRepository;
    private EntityFactory entityFactory;

    public BusInfoDAOImpl(BusLineRepository busLineRepository,BusStopRepository busStopRepository
                          ,BusTypeRepository busTypeRepository,EntityFactory entityFactory,BusScheduleRepository busScheduleRepository){
        this.busLineRepository = busLineRepository;
        this.busStopRepository = busStopRepository;
        this.busTypeRepository = busTypeRepository;
        this.busScheduleRepository = busScheduleRepository;
        this.entityFactory = entityFactory;
    }

    @Override
    public void insertBusTypeInfo(BusTypeDTO busTypeDTO){
        BusType busType = busTypeDTO.toEntity();
        busTypeRepository.save(busType);
        busTypeRepository.flush();
    }

    @Override
    public void insertBusLine(BusLineDTO busLineDTO){
        BusLine busLine = entityFactory.busLinetoEntity(busLineDTO);
        busLineRepository.save(busLine);
        busLineRepository.flush();
    }

    @Override
    public void insertBusStop(BusStopDTO busStopDTO) {
        BusStop busStop = entityFactory.busStopToEntity(busStopDTO);
        busStopRepository.save(busStop);
        busStopRepository.flush();
    }

    @Override
    @Transactional
    public void insertBusSchedule(List<BusScheduleDTO> busScheduleDTO){
        List<BusSchedule> busScheduleList = new ArrayList<BusSchedule>();
        for(BusScheduleDTO now : busScheduleDTO){
            BusSchedule busSchedule = entityFactory.busScheduleToEntity(now);
            busScheduleList.add(busSchedule);
        }
        busScheduleRepository.saveAll(busScheduleList);
        busScheduleRepository.flush();
    }

    @Override
    public List<ScheduleDTO> getBusSchedule(Long busLineSeq,String weekDays){
        List<ScheduleDTO> busScheduleList = busScheduleRepository.getSchedule(busLineSeq,weekDays);
        return  busScheduleList;
    }

    @Override
    public List<ScheduleSchoolDTO> getSchoolBusSchedule(String weekDays) {
        List<ScheduleSchoolDTO> scheduleList = busScheduleRepository.getScheduleSchool(weekDays);
        return scheduleList;
    }

    @Override
    public List<BusLine> getByBusType(Long busTypeSeq) {
        List<BusLine> busLineList = busLineRepository.getByBusTypeAndState(busTypeSeq);
        return busLineList;
    }

}
