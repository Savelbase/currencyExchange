package com.bank.mapper;

import com.bank.dto.TransactionDto;
import lombok.SneakyThrows;

public class TransactionMapper extends BaseMapper {

    @SneakyThrows
    public TransactionDto toDto(String json) {
        return mapper.readValue(json, TransactionDto.class);
    }

}
