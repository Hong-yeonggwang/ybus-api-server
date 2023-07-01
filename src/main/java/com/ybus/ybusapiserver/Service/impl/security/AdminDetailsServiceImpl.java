package com.ybus.ybusapiserver.Service.impl.security;

import com.ybus.ybusapiserver.JPA.repository.admin.AdminRepository;
import com.ybus.ybusapiserver.Service.security.AdminDetailsService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AdminDetailsServiceImpl implements AdminDetailsService {
    private final Logger LOGGER = LoggerFactory.getLogger(AdminDetailsServiceImpl.class);

    private final AdminRepository adminRepository;

    @Override
    public UserDetails loadUserByUsername(String username){
        LOGGER.info("[loadUserByUsername] loadUserByUsername 수행. username:{}",username);
        return adminRepository.getById(username);
    }

}
