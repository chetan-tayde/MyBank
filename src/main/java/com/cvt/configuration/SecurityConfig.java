package com.cvt.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	 @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        http
	            .authorizeRequests()
	            .anyRequest().permitAll()
	            .and()
	            .httpBasic().disable()  // Disable HTTP Basic Authentication
	            .formLogin().disable()  // Disable form login if you don't want it
	            .csrf().disable();

	        return http.build();
	    }

}
