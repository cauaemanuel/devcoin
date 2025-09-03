package com.devcoin.application.dto;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public record BrapiResponse(List<StockDTO> results, Instant requestedAt) {
}
