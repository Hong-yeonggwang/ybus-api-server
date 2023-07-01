package com.ybus.ybusapiserver.JPA.Entity.bus;

import com.ybus.ybusapiserver.DTO.LocationRecentDTO;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@SqlResultSetMapping(
        name="locationRecentDTO",
        classes = @ConstructorResult(
        targetClass = LocationRecentDTO.class,
        columns = {
                @ColumnResult(name="locationseq", type = Long.class),
                @ColumnResult(name="latitude", type = String.class),
                @ColumnResult(name="locationtime", type = LocalDateTime.class),
                @ColumnResult(name="longitude", type = String.class),
                @ColumnResult(name="busstopseq", type = Long.class),
                @ColumnResult(name="deviceseq", type = Long.class),
                @ColumnResult(name="iswithrange", type = Integer.class),
        }))
@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DEVICESEQ")
    private Device deviceSeq;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BUSSTOPSEQ")
    private BusStop busStopSeq;

    @Column(name = "ISWITHRANGE")
    private Integer isWithinRange; // 0또는 1
}