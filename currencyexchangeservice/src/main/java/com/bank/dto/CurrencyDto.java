package com.bank.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CurrencyDto {
    private Integer r030;
    private String txt;
    private BigDecimal rate;
    private String cc;
    private String exchangedate;
}
