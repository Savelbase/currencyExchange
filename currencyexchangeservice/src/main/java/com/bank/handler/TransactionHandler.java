package com.bank.handler;

import com.bank.dto.TransactionDto;
import com.bank.entity.Transaction;
import com.bank.mapper.TransactionMapper;
import com.bank.utils.StringUtil;
import lombok.SneakyThrows;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Date;

public class TransactionHandler implements RestHandler<HttpServletRequest, Transaction> {

    private final TransactionMapper mapper;

    public TransactionHandler() {
        mapper = new TransactionMapper();
    }

    @SneakyThrows
    @Override
    public Transaction post(HttpServletRequest request) {
        TransactionDto dto = mapper.toDto(StringUtil.readAll(request.getInputStream()));
        // FIXME: Invoke service to save transaction
        return new Transaction(null, new Date(), dto.getSell(), dto.getBuy(), dto.getAmount());
    }
}
