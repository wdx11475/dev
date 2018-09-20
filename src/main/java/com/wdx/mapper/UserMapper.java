package com.wdx.mapper;

import com.wdx.model.User;

public interface UserMapper {

    User findByName(String name);

    User findById(Integer id);

    void save(User user);
}
