package com.ybus.ybusapiserver.JPA.Entity.bus;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    @Column(name="BUSLINESEQ")
    private Long busLineSeq;

    @Column(name = "BUSLINE")
    private String busLine;

    @Column(name = "BUSLINESTATE")
    private String busLineState;

    @ManyToOne
    @JoinColumn(name = "BUSTYPESEQ")
    private BusType busTypeSeq;

    @OneToMany(mappedBy = "busLineSeq")
    private List<BusStop> busLines = new ArrayList<BusStop>();

}
