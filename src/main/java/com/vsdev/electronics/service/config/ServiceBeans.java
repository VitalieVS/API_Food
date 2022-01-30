package com.vsdev.electronics.service.config;

import com.vsdev.electronics.service.accessors.DateAccessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceBeans {

    @Bean
    public DateAccessor dateAccessor() {
        return new DateAccessor();
    }

}
