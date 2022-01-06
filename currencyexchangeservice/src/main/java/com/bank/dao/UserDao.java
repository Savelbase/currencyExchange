package com.bank.dao;

import com.bank.dto.UserDto;
import com.bank.entity.User;

public interface UserDao extends Dao<User, Long> {

    User findByLogin(String login);

    User get(User user);
}
