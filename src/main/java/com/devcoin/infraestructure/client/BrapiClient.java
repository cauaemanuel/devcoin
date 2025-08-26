package com.devcoin.infraestructure.client;

import com.devcoin.application.dto.BrapiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "brapi", url = "https://brapi.dev/api")
public interface BrapiClient {

    @GetMapping(value = "/quote/{stockId}")
    BrapiResponse getQuote(@RequestParam("token") String token,
                           @PathVariable("stockId") String stockId);
}
