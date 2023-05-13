package com.ybus.ybusapiserver.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    private final JwtProvider jwtProvider;

    @Autowired
    public SecurityConfiguration(JwtProvider jwtProvider){
        this.jwtProvider = jwtProvider;
    }
    @Override
    protected void configure (HttpSecurity httpSecurity) throws Exception{
        httpSecurity.httpBasic().disable()
                .csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests()
                .antMatchers("/sign-api/sign-in","/sign-api/sign-up","/sign-api/exception").permitAll()
                .antMatchers("/bus/request","bus/token","/gper/**").permitAll()
                .antMatchers("**excetion**").permitAll()
                .anyRequest().hasRole("ADMIN")
                .and()
                .exceptionHandling().accessDeniedHandler(new CustomAccessDeniedHandler())
                .and()
                .exceptionHandling().authenticationEntryPoint(new CustomAuthenticationEntryPoint())
                .and()
                .addFilterBefore(new JwtAuthenticationFilter(jwtProvider), UsernamePasswordAuthenticationFilter.class);

    }
    @Override
    public void configure(WebSecurity webSecurity){
        webSecurity.ignoring().antMatchers("/bus/request","bus/token");
    }
}
