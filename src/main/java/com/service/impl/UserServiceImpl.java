package com.service.impl;

import com.alibaba.fastjson.JSON;
import com.entity.User;
import com.mapper.UserMapper;
import com.service.UserService;
import com.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User get(User user) {
        try {
            User entity = userMapper.get(user.getId());
            return entity;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public User login(User user) {
        Map<String, Object> map = JSON.parseObject(JSON.toJSONString(user));
        map.put("password", MD5Util.MD5(user.getPassword()));
        User entity = userMapper.login(map);
        return entity;
    }

    @Override
    public List<User> getList(User user) {
        Map<String, Object> map = JSON.parseObject(JSON.toJSONString(user));
        List<User> list = userMapper.getList(map);
        return list;
    }
}
