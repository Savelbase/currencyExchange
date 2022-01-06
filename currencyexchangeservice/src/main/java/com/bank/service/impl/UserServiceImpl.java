package com.bank.service.impl;

import com.bank.dao.UserDao;
import com.bank.dao.impl.UserDaoImpl;
import com.bank.entity.User;
import com.bank.service.UserService;

public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl() {
        userDao = new UserDaoImpl();
    }


    @Override
    public User save(User user) {
        return userDao.save(user);
    }

    @Override
    public User get(User user) {
        return userDao.get(user);

    }
}
