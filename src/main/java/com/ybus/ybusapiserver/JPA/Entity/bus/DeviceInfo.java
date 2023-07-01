package com.ybus.ybusapiserver.JPA.Entity.bus;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "DEVICEINFO")
public class DeviceInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="DEVICEINFOSEQ")
    private Long deviceInfoSeq;

    @Column(name = "DEVICEREGDATE")
    private LocalDateTime deviceRegdate;

    @Column(name = "DEVICESTATE")
    private String deviceState;

    @Column(name = "BUSNUMBER")
    private String busNumber;

    @Column(name = "BUSALIAS")
    private String busAlias;

    @ManyToOne
    @JoinColumn(name = "BUSTYPESEQ")
    private BusType busType;

    @ManyToOne
    @JoinColumn(name = "BUSLINESEQ")
    private BusLine busLine;

    @OneToOne(mappedBy = "deviceInfoSeq")
    private Device deviceSeq;

}
