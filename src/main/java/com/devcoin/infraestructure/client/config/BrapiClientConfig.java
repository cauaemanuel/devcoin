package com.devcoin.infraestructure.client.config;

import com.devcoin.infraestructure.client.interceptors.ApiKeyBrapiRequestInterceptors;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BrapiClientConfig {

    private String apiKey = "2hbAgiGgLRSHCLuohYBnTf";

    @Bean
    public RequestInterceptor apiKeyBrapiRequestInterceptors() {
        return new ApiKeyBrapiRequestInterceptors(apiKey);
    }
}
