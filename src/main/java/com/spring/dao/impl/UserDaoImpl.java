package com.spring.dao.impl;

import com.spring.dao.UserDao;

public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("save...");
    }
}
