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
     *
     * @return 查询所有用户数
     */
    int selectCountUser();
}