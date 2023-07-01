package com.ybus.ybusapiserver.DTO.security;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SignUpResultDTO {
    private boolean success;
    private int code;
    private String msg;
}
