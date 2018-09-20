package com.wdx.servcie.impl;

import com.wdx.mapper.UserMapper;
import com.wdx.model.User;
import com.wdx.servcie.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByName(String name) {
        return userMapper.findByName(name);
    }

    @Override
    public User findById(Integer id) {
        return userMapper.findById(id);
    }

    @Override
    public void save(User user) {
        userMapper.save(user);
    }
}
