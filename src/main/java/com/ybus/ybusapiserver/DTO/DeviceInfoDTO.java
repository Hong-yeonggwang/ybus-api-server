package com.ybus.ybusapiserver.DTO;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DeviceInfoDTO {
    private Long deviceInfoSeq;
    private LocalDateTime deviceRegdate;
    private String deviceState;
    private Long deviceSeq;
    private String busNumber;
    private String busAlias;
    private Long busType;
    private Long busLine;
}
