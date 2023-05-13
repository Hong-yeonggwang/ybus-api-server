package com.ybus.ybusapiserver.DTO;

import lombok.*;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LocationInsertDTO {

    private String device_sn; // 디바이스 기기 번호
    private Long location_date; // 위치의 조회 시간
    private double latitude;
    private double longitude;
    private String member_key;
}
