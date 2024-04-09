package com.example.testappforivan.app.presentation.currency.dto.commands;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Data
@Builder
public class UpdateCurrencyCommands {
    private String index;

    private Integer id;

    private BigDecimal purchase;

    private BigDecimal sale;

    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;
}
