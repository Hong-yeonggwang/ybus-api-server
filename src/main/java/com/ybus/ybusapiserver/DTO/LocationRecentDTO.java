package com.ybus.ybusapiserver.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class LocationRecentDTO{
    public LocationRecentDTO(Long locationSeq, String latitude,LocalDateTime locationTime,String longitude, Long deviceSeq,
                      Long busStopSeq, Integer isWithRange){
        this.locationSeq = locationSeq;
        this.latitude = latitude;
        this.longitude = longitude;
        this.locationTime = locationTime;
        this.deviceSeq = deviceSeq;
        this.busStopSeq = busStopSeq;
        this.isWithRange = isWithRange;

    }

    private Long locationSeq;
    private String latitude;
    private String longitude;
    private LocalDateTime locationTime;
    private Long deviceSeq;
    private Long busStopSeq;
    private Integer isWithRange;
}