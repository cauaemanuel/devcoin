package com.devcoin.infraestructure.client.config;

import com.devcoin.infraestructure.client.interceptors.ApiKeyBrapiRequestInterceptors;
import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BrapiClientConfig {

    @Value("${brapi.api.key}")
    private String apiKey;

    @Bean
    public RequestInterceptor apiKeyBrapiRequestInterceptors() {
        return new ApiKeyBrapiRequestInterceptors(apiKey);
    }
}
