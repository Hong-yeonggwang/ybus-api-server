package com.ybus.ybusapiserver.DTO;

import com.ybus.ybusapiserver.JPA.Entity.bus.BusStop;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class BusStopDTO {
    private String busStop;
    private String latitude;
    private String longitude;
    private String busStopLine;
    private int busStopOrder;
    private Long busLineSeq;
}
