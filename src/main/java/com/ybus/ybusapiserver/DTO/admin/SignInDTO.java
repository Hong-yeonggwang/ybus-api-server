package com.ybus.ybusapiserver.DTO.admin;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignInDTO {
    private String id;
    private String password;
}
