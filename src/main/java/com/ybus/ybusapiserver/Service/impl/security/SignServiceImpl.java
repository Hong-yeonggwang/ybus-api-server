package com.ybus.ybusapiserver.Service.impl.security;

import com.ybus.ybusapiserver.Common.CommonResponse;
import com.ybus.ybusapiserver.Config.security.JwtProvider;
import com.ybus.ybusapiserver.DTO.security.SignInResultDTO;
import com.ybus.ybusapiserver.DTO.security.SignUpResultDTO;
import com.ybus.ybusapiserver.JPA.Entity.admin.Admin;
import com.ybus.ybusapiserver.JPA.repository.admin.AdminRepository;
import com.ybus.ybusapiserver.Service.security.SignService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class SignServiceImpl implements SignService {
    private final Logger LOGGER = LoggerFactory.getLogger(SignServiceImpl.class);

    public AdminRepository adminRepository;
    public JwtProvider jwtProvider;
    public PasswordEncoder passwordEncoder;

    @Autowired
    public SignServiceImpl(AdminRepository adminRepository,JwtProvider jwtProvider, PasswordEncoder passwordEncoder){
        this.adminRepository = adminRepository;
        this.jwtProvider = jwtProvider;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public SignUpResultDTO signUp(String id, String password, String name, String role) {
        LOGGER.info("[getSignUpResult] 회원 가입 정보 전달");
        Admin admin;
        if(role.equalsIgnoreCase("admin")){
            admin = Admin.builder()
                    .id(id)
                    .name(name)
                    .password(passwordEncoder.encode(password))
                    .roles((Collections.singletonList("ROLE_ADMIN")))
                    .build();
        }else{
            admin = Admin.builder()
                    .id(id)
                    .name(name)
                    .password(passwordEncoder.encode(password))
                    .roles((Collections.singletonList("ROLE_USER")))
                    .build();
        }
        Admin savedAdmin = adminRepository.save(admin);
        SignUpResultDTO signUpResultDTO = new SignUpResultDTO();

        LOGGER.info("[getSignUpResult] adminEntity 값이 들어왔는지 확인 후 결과값 주입");
        if(!savedAdmin.getName().isEmpty()){
            LOGGER.info("[getSignUpResult] 정상 처리 완료 ");
            setSuccessResult(signUpResultDTO);
        }else{
            LOGGER.info("[getSignUpResult] 실패 처리 완료 ");
            setFailResult(signUpResultDTO);
        }
        return signUpResultDTO;
    }

    @Override
    public SignInResultDTO signIn(String id, String password) throws RuntimeException {
        LOGGER.info("[getSignInResult] signDataHandler로 회원 정보 요청");
        Admin admin = adminRepository.getById(id);
        LOGGER.info("[getSignInResult] id : {} ",id);

        LOGGER.info("[getSignInResult] 패스워드 비교 수행");

        if(!passwordEncoder.matches(password, admin.getPassword())){
            throw new RuntimeException();
        }
        LOGGER.info("[getSignInResult] 패스워드 일치");

        LOGGER.info("[getSignInResult] signInResultDTO 객체 생성");
        SignInResultDTO signInResultDTO = SignInResultDTO.builder()
                .token(jwtProvider.createToken(String.valueOf(admin.getId()),admin.getRoles()))
                .build();

        LOGGER.info("[getSignInResult] SignInResultDto 객체에 값 주입");
        setSuccessResult(signInResultDTO);
        return signInResultDTO;
    }

    private void setSuccessResult(SignUpResultDTO result){
        result.setSuccess(true);
        result.setCode(CommonResponse.SUCCESS.getCode());
        result.setMsg(CommonResponse.SUCCESS.getMsg());
    }
    private void setFailResult(SignUpResultDTO result){
        result.setSuccess(true);
        result.setCode(CommonResponse.SUCCESS.getCode());
        result.setMsg(CommonResponse.SUCCESS.getMsg());
    }
}
