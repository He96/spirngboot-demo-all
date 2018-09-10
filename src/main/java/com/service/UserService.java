package com.service;

import com.entity.User;

import java.util.List;

public interface UserService {
    /**
     * 用户登录
     * @param user
     * @return
     */
    User get(User user);

    User login(User user);

    List<User> getList(User user);
}
