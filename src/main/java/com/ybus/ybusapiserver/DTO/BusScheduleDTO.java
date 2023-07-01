package com.ybus.ybusapiserver.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class BusScheduleDTO {
    private int timeHour;
    private int timeMinute;
    private String courseName;
    private String weekDays;
    private Long busLineSeq;
}
