package com.ybus.ybusapiserver.Service.security;

import com.ybus.ybusapiserver.DTO.security.SignInResultDTO;
import com.ybus.ybusapiserver.DTO.security.SignUpResultDTO;

public interface SignService {
    SignUpResultDTO signUp(String id, String password, String name, String role);
    SignInResultDTO signIn(String id, String password) throws RuntimeException;
}
