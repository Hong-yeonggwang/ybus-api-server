package com.ybus.ybusapiserver.JPA.Entity.bus;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="LOCATIONSEQ")
    private Long locationSeq;

    @Column(name = "LATITUDE")
    private String latitude;

    @Column(name = "LONGITUDE")
    private String longitude;

    @Column(name = "LOCATIONTIME")
    private LocalDateTime locationTime;

    @ManyToOne
    private Device deviceSeq;

    @ManyToOne
    @JoinColumn(name = "BUSSTOPSEQ")
    private BusStop busStopSeq;
}
