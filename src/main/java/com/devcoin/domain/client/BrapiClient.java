package com.devcoin.domain.client;

import com.devcoin.application.dto.BrapiResponse;

public interface BrapiClient {

    BrapiResponse getQuote(String stockId);
}
