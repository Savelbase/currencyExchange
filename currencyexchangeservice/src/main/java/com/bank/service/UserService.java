package com.bank.service;

import com.bank.entity.User;

public interface UserService {

    User save(User user);

    User get(User user);
}
