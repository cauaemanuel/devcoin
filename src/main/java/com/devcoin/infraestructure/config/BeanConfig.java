package com.devcoin.infraestructure.config;

import com.devcoin.domain.client.BrapiClient;
import com.devcoin.infraestructure.client.BrapiClientImplements;
import com.devcoin.infraestructure.client.SpringBrapiClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public BrapiClient brapiClient(SpringBrapiClient springBrapiClient){
        return new BrapiClientImplements(springBrapiClient);
    }


}
