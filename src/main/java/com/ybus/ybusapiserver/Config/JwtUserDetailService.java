package com.ybus.ybusapiserver.Config;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class JwtUserDetailService implements UserDetailsService{

    @Value("spring.jwt.secret")
    private String secretKey = "secretKey";
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes(StandardCharsets.UTF_8));
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ADMIN"));
        if ("yeonggwang".equals(username)) {
            return new User("yeonggwang", secretKey,
                    authorities);
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}