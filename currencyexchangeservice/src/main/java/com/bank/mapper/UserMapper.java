package com.bank.mapper;

import com.bank.entity.User;
import lombok.SneakyThrows;

public class UserMapper extends BaseMapper {
    @SneakyThrows
    public User toDto(String json) {
        return mapper.readValue(json, User.class);
    }
}
