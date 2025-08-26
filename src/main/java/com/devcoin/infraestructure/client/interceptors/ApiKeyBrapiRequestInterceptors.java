package com.devcoin.infraestructure.client.interceptors;

import feign.RequestInterceptor;
import feign.RequestTemplate;

public class ApiKeyBrapiRequestInterceptors implements RequestInterceptor {

    private String apiKey;

    public ApiKeyBrapiRequestInterceptors(String apiKey) {
        this.apiKey = apiKey;
    }

    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.query("token", apiKey);
    }
}
