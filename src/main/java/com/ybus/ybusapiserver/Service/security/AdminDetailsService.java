package com.ybus.ybusapiserver.Service.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface AdminDetailsService {

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
