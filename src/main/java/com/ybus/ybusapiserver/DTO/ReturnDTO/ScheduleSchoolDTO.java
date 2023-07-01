package com.ybus.ybusapiserver.DTO.ReturnDTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@ToString
public class ScheduleSchoolDTO {
    private LocalTime busTime;
    private LocalDateTime busUpdataTime;
    private String courseName;
    private String busLineName;
    private Integer fee;


    public ScheduleSchoolDTO(LocalTime busTime, LocalDateTime busUpdataTime, String courseName, String busLineName,Integer fee) {
        this.busTime = busTime;
        this.busUpdataTime = busUpdataTime;
        this.courseName = courseName;
        this.busLineName =busLineName;
        this.fee = fee;
    }
}
