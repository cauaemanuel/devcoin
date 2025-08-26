package com.devcoin.infraestructure.client.fallback;

import com.devcoin.application.dto.BrapiResponse;
import com.devcoin.infraestructure.client.SpringBrapiClient;
import org.springframework.stereotype.Component;

@Component
public class SpringBrapiClientFallback implements SpringBrapiClient {

    @Override
    public BrapiResponse getQuote(String stockId) {
        throw new RuntimeException("Brapi service is unavailable");
    }
}
