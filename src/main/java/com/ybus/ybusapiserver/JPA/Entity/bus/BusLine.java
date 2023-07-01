package com.ybus.ybusapiserver.JPA.Entity.bus;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @Column(name = "FEE")
    private Integer fee;

    @ManyToOne
    @JoinColumn(name = "BUSTYPESEQ")
    private BusType busTypeSeq;

    @OneToMany(mappedBy = "busLineSeq")
    private transient List<BusStop> busLines = new ArrayList<BusStop>();

}
