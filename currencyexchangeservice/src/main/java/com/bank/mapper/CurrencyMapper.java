package com.bank.mapper;

import com.bank.dto.CurrencyDto;
import lombok.SneakyThrows;

public class CurrencyMapper extends BaseMapper{

    @SneakyThrows
    public CurrencyDto toDto(String json) {
        return mapper.readValue(json, CurrencyDto.class);
    }

}
