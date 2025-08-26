package com.devcoin.infraestructure.client;

import com.devcoin.application.dto.BrapiResponse;
import com.devcoin.domain.client.BrapiClient;
import org.springframework.stereotype.Component;

@Component
public class BrapiClientImplements implements BrapiClient {

    private SpringBrapiClient springBrapiClient;

    public BrapiClientImplements(SpringBrapiClient springBrapiClient) {
        this.springBrapiClient = springBrapiClient;
    }

    public BrapiResponse getQuote(String stockId) {
        return springBrapiClient.getQuote(stockId);
    }
}
