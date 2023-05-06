package com.ybus.ybusapiserver.JPA.Entity.bus;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "DEVICE")
@ToString
@EntityListeners(AuditingEntityListener.class)
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="DEVICESEQ")
    private Long deviceSeq;

    @Column(name = "DEVICEHASHKEY")
    private String deviceHashKey;

    @Column(name = "DEVICENAME")
    private String deviceName;

    @CreatedDate
    @Column(name = "UPDATETIME")
    private LocalDateTime updateTime;

    @OneToMany(mappedBy = "deviceSeq")
    private List<Location> device = new ArrayList<Location>();

}
