package com.ybus.ybusapiserver.JPA.Entity.bus;

import lombok.*;

import javax.persistence.*;

@Getter
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

    @Column(name = "BUSSTOPORDER")
    private int busStopOrder;

    @OneToOne
    @JoinColumn(name = "BUSSLINESEQ")
    private BusLine busLineSeq;
}
