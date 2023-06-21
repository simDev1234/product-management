package com.notagkorea.productManagment.global.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class WebConfig {

    // TODO Security로 이동
    public static final String AUTHORIZATION_HEADER = "Authorization";

    @Bean
    public RestTemplate restTemplate() {

        return new RestTemplate();
    }

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

}
