package com.bank.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDto {
    private Long userID ;
    private Currency sell;
    private Currency buy;
    private BigDecimal amount;
}
