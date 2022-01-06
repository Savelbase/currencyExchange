package com.bank.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

public class BaseMapper {

    protected final ObjectMapper mapper;

    public BaseMapper() {
        mapper = new ObjectMapper();
    }

    @SneakyThrows
    public String toJson(Object object) {
        return mapper.writeValueAsString(object);
    }
}
