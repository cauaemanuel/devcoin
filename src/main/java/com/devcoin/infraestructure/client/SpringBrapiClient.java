package com.devcoin.infraestructure.client;

import com.devcoin.application.dto.BrapiResponse;
import com.devcoin.infraestructure.client.config.BrapiClientConfig;
import com.devcoin.infraestructure.client.fallback.SpringBrapiClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "brapi",
        url = "https://brapi.dev/api",
        configuration = BrapiClientConfig.class,
        fallback = SpringBrapiClientFallback.class
)
public interface SpringBrapiClient {

    @GetMapping(value = "/quote/{stockId}")
    BrapiResponse getQuote(@PathVariable("stockId") String stockId);
}
