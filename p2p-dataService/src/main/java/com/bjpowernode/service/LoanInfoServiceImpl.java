package com.bjpowernode.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.bjpowernode.Constants;
import com.bjpowernode.mapper.LoanInfoMapper;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author 侯旭东
 * @version 1.0
 * @date 2020/12/4 16:30
 */
@Component
@Service(interfaceClass = LoanInfoService.class,timeout = 3500,version = "1.0")
public class LoanInfoServiceImpl implements LoanInfoService {
    @Resource
    private LoanInfoMapper loanInfoMapper;
    @Resource
    private RedisTemplate redisTemplate;
    @Override
    public Double queryRateAverage() {
        Double rateAverage = 0.0;
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        rateAverage = (Double)redisTemplate.opsForValue().get(Constants.YEAR_RATE);
        if (rateAverage == null){
            synchronized (this){
                rateAverage = loanInfoMapper.selectRateAverAge();
                redisTemplate.opsForValue().set(Constants.YEAR_RATE,rateAverage,20, TimeUnit.MINUTES);
            }
        }
        return rateAverage;
    }
}
