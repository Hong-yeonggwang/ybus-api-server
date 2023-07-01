package com.ybus.ybusapiserver.JPA.Entity.bus;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name =  "BUSSCHEDULE")
public class BusSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="BUSSCHEDULESEQ")
    private Long busScheduleSeq;

    @Column(name = "BUSTIME")
    private LocalTime busTime;

    @Column(name = "COURSENAME")
    private String courseName;

    @Column(name = "WEEKDAYS")
    private String weekDays;

    @ManyToOne
    @JoinColumn(name = "BUSLINESEQ")
    private BusLine busLineSeq;

    @Column(name = "BUSUPDATETIME")
    private LocalDateTime busUpdataTime;
}
