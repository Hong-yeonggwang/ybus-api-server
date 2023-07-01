package com.ybus.ybusapiserver.DTO;

import com.ybus.ybusapiserver.JPA.Entity.bus.Device;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DeviceDTO {
    private String deviceHashKey;
    private String deviceName;
    private LocalDateTime updateTime;
    private Long deviceSeq;
}
