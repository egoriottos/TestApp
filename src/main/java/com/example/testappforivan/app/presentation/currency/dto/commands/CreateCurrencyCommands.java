package com.example.testappforivan.app.presentation.currency.dto.commands;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class CreateCurrencyCommands {
    private String index;

    private BigDecimal purchase;

    private BigDecimal sale;
}
