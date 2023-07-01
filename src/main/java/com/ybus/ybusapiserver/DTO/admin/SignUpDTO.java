package com.ybus.ybusapiserver.DTO.admin;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SignUpDTO {
    private String id;
    private String password;
    private String name;
    private String role;
}
