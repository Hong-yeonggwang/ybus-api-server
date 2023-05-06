package com.ybus.ybusapiserver.DTO;

import com.ybus.ybusapiserver.JPA.Entity.bus.BusType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BusTypeDTO {
    private String busType;
    private String busTypeState;

    public BusType toEntity(){
        BusType busTypeEntity = BusType.builder().busType(this.busType).busTypeState(this.busTypeState).build();
        return busTypeEntity;
    }
}
