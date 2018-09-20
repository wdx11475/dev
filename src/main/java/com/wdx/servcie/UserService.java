package com.wdx.servcie;

import com.wdx.model.User;

public interface UserService {
    User findByName(String name);

    User findById(Integer id);

    void save(User user);
}
