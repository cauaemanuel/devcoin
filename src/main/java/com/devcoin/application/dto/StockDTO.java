package com.devcoin.application.dto;

public record StockDTO(
        String symbol,
        String longName,
        Double regularMarketPrice,
        String marketCap,
        String currency
){
}
