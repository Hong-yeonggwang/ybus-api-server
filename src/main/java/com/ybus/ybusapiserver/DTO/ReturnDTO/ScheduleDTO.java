package com.ybus.ybusapiserver.DTO.ReturnDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@ToString
public class ScheduleDTO {
    private LocalTime busTime;
    private LocalDateTime busUpdataTime;
    private String courseName;

    public ScheduleDTO(LocalTime busTime, LocalDateTime busUpdataTime, String courseName) {
        this.busTime = busTime;
        this.busUpdataTime = busUpdataTime;
        this.courseName = courseName;
    }

}
