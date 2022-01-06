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
public class Transaction {
    private Long id;
    private Date created;
    private Currency sell;
    private Currency buy;
    private BigDecimal amount;

}
