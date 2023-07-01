package com.ybus.ybusapiserver.Controller;

import com.ybus.ybusapiserver.DTO.admin.SignInDTO;
import com.ybus.ybusapiserver.DTO.admin.SignUpDTO;
import com.ybus.ybusapiserver.DTO.security.SignInResultDTO;
import com.ybus.ybusapiserver.DTO.security.SignUpResultDTO;
import com.ybus.ybusapiserver.Service.security.SignService;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/sign-api")
public class SignController {
    private final Logger LOGGER = LoggerFactory.getLogger(SignController.class);
    private final SignService signService;

    @Autowired
    public SignController(SignService signService){
        this.signService = signService;
    }

    @PostMapping(value = "/sign-in")
    public SignInResultDTO signIn(@RequestBody SignInDTO signInDTO)throws RuntimeException{
        LOGGER.info("[signIn] 로그인을 시도하고 있습니다.");
        SignInResultDTO signInResultDTO = signService.signIn(signInDTO.getId(), signInDTO.getPassword());

        if(signInResultDTO.getCode() == 0){
            LOGGER.info("[signIn] 정상적으로 로그인되었습니다.");
        }
        return signInResultDTO;
    }
    @PostMapping(value = "/sign-up")
    public SignUpResultDTO signUp(@RequestBody SignUpDTO signUpDTO){
        LOGGER.info("[signUp] 회원가입을 수행합니다.");
        SignUpResultDTO signUpResultDTO = signService.signUp(signUpDTO.getId(), signUpDTO.getPassword(), signUpDTO.getName(), signUpDTO.getRole());
        LOGGER.info("[signUp] 회원가입 완료.");
        return signUpResultDTO;
    }
    @GetMapping(value = "/exception")
    public void exceptionTest() throws RuntimeException{
        throw new RuntimeException("접근이 금지되었습니다.");
    }

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<Map<String,String>> ExceptionHandler(RuntimeException e){
        HttpHeaders responseHeaders = new HttpHeaders();
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        LOGGER.info("ExceptionHandler 호출.");
        LOGGER.info(e.getCause().toString());
        LOGGER.info(e.getMessage().toString());

        Map<String,String> map = new HashMap<>();
        map.put("error type",httpStatus.getReasonPhrase());
        map.put("code","400");
        map.put("message","에러 발생");

        return new ResponseEntity<>(map,responseHeaders,httpStatus);

    }

}
