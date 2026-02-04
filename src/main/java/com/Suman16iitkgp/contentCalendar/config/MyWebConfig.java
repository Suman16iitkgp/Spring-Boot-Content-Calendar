package com.Suman16iitkgp.contentCalendar.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MyWebConfig {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
