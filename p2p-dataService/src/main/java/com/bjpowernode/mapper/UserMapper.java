package com.bjpowernode.mapper;

import com.bjpowernode.domain.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 查询所有用户数
     * @return 所有用户的总数量
     */
    int selectCountUser();

    /**
     *  查询用户根据手机号
     * @param phone 用户的手机号
     * @return 返回用户的信息
     */
    User selectUserByPhone(String phone);
}