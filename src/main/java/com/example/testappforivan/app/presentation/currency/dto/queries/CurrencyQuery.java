package com.example.testappforivan.app.presentation.currency.dto.queries;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CurrencyQuery {
    private String index;

    private BigDecimal purchase;

    private BigDecimal sale;
}
