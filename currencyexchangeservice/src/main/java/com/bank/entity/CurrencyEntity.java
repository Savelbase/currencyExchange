package com.bank.entity;

import com.bank.dto.Currency;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CurrencyEntity {
    private Long id;
    private Currency code;
    private BigDecimal rate;
    private Date timeCreation;
    private Boolean updated;
}
