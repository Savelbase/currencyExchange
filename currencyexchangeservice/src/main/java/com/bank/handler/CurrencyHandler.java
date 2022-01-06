package com.bank.handler;

import com.bank.dto.Currency;
import com.bank.dto.CurrencyDto;
import com.bank.entity.CurrencyEntity;
import com.bank.mapper.CurrencyMapper;
import com.bank.utils.StringUtil;
import lombok.SneakyThrows;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

public class CurrencyHandler implements RestHandler<HttpServletRequest, CurrencyEntity>{
    
    private final CurrencyMapper mapper;

    public CurrencyHandler() {
        mapper = new CurrencyMapper();
    }
    
    @SneakyThrows
    public CurrencyEntity post(HttpServletRequest request) {
        CurrencyDto dto = mapper.toDto(StringUtil.readAll(request.getInputStream()));
        return new CurrencyEntity(null, Currency.valueOf(dto.getCc()), dto.getRate(), new Date(), false);
    }
}
