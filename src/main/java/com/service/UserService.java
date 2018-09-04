package com.service;

import com.entity.User;

public interface UserService {
    /**
     * 用户登录
     * @param user
     * @return
     */
    User get(User user);

    User login(User user);
}
