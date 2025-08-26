package com.devcoin.infraestructure.client.fallback;

import com.devcoin.application.dto.BrapiResponse;
import com.devcoin.infraestructure.client.BrapiClient;
import org.springframework.stereotype.Component;

@Component
public class BrapiClientFallback implements BrapiClient {
    @Override
    public BrapiResponse getQuote(String stockId) {
        return new BrapiResponse(null);
    }
}
