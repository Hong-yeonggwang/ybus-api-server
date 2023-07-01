package com.ybus.ybusapiserver.JPA.Entity.bus;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "BUSSTOP")
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BusStop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="BUSSTOPSEQ")
    private Long busStopSeq;

    @Column(name = "BUSSTOP")
    private String busStop;

    @Column(name = "LATITUDE")
    private String latitude;

    @Column(name = "LONGITUDE")
    private String longitude;

    @Column(name = "BUSSTOPLINE")
    private String busStopLine; // 상행,하행
    @Column(name = "ISSTOPPED")
    private int isStopped;

    @Column(name = "BUSSTOPORDER")
    private int busStopOrder;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BUSLINESEQ")
    private BusLine busLineSeq;

    @OneToMany(mappedBy = "busStopSeq")
    private List<Location> locations = new ArrayList<Location>();

}
