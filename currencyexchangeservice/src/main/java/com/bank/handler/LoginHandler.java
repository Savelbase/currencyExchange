package com.bank.handler;

import com.bank.entity.User;
import com.bank.mapper.UserMapper;
import com.bank.service.UserService;
import com.bank.service.impl.UserServiceImpl;
import com.bank.utils.StringUtil;
import lombok.SneakyThrows;

import javax.servlet.http.HttpServletRequest;

public class LoginHandler implements RestHandler<HttpServletRequest, User> {

    private final UserService userService;
    private final UserMapper userMapper;

    public LoginHandler() {
        userService = new UserServiceImpl();
        userMapper = new UserMapper();
    }

    @SneakyThrows
    @Override
    public User post(HttpServletRequest req) {
        User user = userMapper.toDto(StringUtil.readAll(req.getInputStream()));
        return userService.save(user);
    }

}
