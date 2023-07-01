package com.ybus.ybusapiserver.JPA.repository.bus;

import com.ybus.ybusapiserver.DTO.ReturnDTO.ScheduleDTO;
import com.ybus.ybusapiserver.DTO.ReturnDTO.ScheduleSchoolDTO;
import com.ybus.ybusapiserver.JPA.Entity.bus.BusSchedule;
import com.ybus.ybusapiserver.JPA.QueryDslCustom.BusScheduleRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BusScheduleRepository extends JpaRepository<BusSchedule,Long>, BusScheduleRepositoryCustom {

    @Query("SELECT new com.ybus.ybusapiserver.DTO.ReturnDTO.ScheduleDTO(e.busTime,e.busUpdataTime,e.courseName) FROM BusSchedule e WHERE e.busLineSeq.busLineSeq = :busLineSeq AND e.weekDays = :weekDays")
    List<ScheduleDTO> getSchedule(@Param("busLineSeq") Long busLineSeq, @Param("weekDays") String weekDays);

    @Query("SELECT new com.ybus.ybusapiserver.DTO.ReturnDTO.ScheduleSchoolDTO(e.busTime,e.busUpdataTime,e.courseName,e.busLineSeq.busLine,e.busLineSeq.fee) FROM BusSchedule e WHERE e.busLineSeq.busTypeSeq = '3' AND e.weekDays = :weekDays order by e.courseName")
    List<ScheduleSchoolDTO> getScheduleSchool(@Param("weekDays") String weekDays);

}
