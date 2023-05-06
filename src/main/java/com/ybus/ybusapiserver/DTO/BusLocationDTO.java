package com.ybus.ybusapiserver.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder

public class BusLocationDTO {
    private Long deviceSeq;
    private String deviceLat;
    private String deviceLng;
}


//{
//  "deviceSeq":"159",
//  "deviceLat":"123123123",
//  "deviceLng":"123213123"
//}