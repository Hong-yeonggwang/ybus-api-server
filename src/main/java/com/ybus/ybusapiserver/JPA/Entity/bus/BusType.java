package com.ybus.ybusapiserver.JPA.Entity.bus;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "BUSTYPE")
@ToString
public class BusType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BUSTYPESEQ")
    private Long busTypeSeq;

    @Column(name = "BUSTYPE")
    private String busType;

    @Column(name = "BUSTYPESTATE")
    private String busTypeState;
}
