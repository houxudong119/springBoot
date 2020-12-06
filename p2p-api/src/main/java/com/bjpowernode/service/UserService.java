package com.bjpowernode.service;

import com.bjpowernode.domain.User;

/**
 * @author 侯旭东
 * @version 1.0
 * @date 2020/12/4 20:19
 */
public interface UserService {
    /**
     *  查询所有的注册用户数
     * @return 所有的注册用户数
     */
    int queryCountUser();

    /**
     * 通过用户的手机号查询用户信息
     * @param phone 用户的手机号
     * @return 用户
     */
    User queryUserByPhone(String phone);
}
