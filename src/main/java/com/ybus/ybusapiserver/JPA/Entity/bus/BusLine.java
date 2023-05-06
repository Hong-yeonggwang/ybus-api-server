package com.ybus.ybusapiserver.JPA.Entity.bus;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "BUSLINE")
@ToString
public class BusLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="BUSTLINESEQ")
    private Long busLineSeq;

    @Column(name = "BUSLINE")
    private String busLine;

    @Column(name = "BUSLINESTATE")
    private String busLineState;

    @ManyToOne
    @JoinColumn(name = "BUSTYPESEQ")
    private BusType busTypeSeq;
}
