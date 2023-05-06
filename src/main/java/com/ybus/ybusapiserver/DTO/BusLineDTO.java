package com.ybus.ybusapiserver.DTO;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BusLineDTO {
    private String busLine;
    private String busLineState;
    private Long busTypeSeq;
}
