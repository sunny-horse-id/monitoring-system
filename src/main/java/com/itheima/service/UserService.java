package com.itheima.service;

import com.itheima.pojo.User;

public interface UserService {
    /**
     * 查找用户
     * @param username
     * @return
     */
    User findByUserName(String username);

    /**
     * 用户登录
     * @param username
     * @param password
     */
    void register(String username, String password);
}
