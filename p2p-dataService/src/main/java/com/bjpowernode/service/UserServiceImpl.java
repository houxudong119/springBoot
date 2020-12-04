package com.bjpowernode.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.bjpowernode.Constants;
import com.bjpowernode.mapper.UserMapper;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author 侯旭东
 * @version 1.0
 * @date 2020/12/4 20:20
 */
@Component
@Service(interfaceClass = UserService.class,version = "1.0",timeout = 3500)
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private RedisTemplate redisTemplate;
    @Override
    public int queryCountUser() {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        Integer countUser = null;
        countUser = (Integer) redisTemplate.opsForValue().get(Constants.COUNT_USER);
        if (countUser == null){
            synchronized (this){
                countUser = userMapper.selectCountUser();
                redisTemplate.opsForValue().set(Constants.COUNT_USER,countUser,20, TimeUnit.MINUTES);
            }
        }
        return countUser;
    }
}
