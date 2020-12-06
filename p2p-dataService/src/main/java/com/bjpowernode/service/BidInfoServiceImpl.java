package com.bjpowernode.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.bjpowernode.Constants;
import com.bjpowernode.mapper.BidInfoMapper;
import com.bjpowernode.vo.UserBidInfo;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author 侯旭东
 * @version 1.0
 * @date 2020/12/4 21:15
 */
@Component
@Service(interfaceClass = BidInfoService.class,timeout = 3500,version = "1.0")
public class BidInfoServiceImpl implements BidInfoService {
    @Resource
    private BidInfoMapper bidInfoMapper;
    @Resource
    private RedisTemplate redisTemplate;
    @Override
    public Double queryTotalBidMoney() {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        Double totalBidMoney = 0.0;
        totalBidMoney = (Double) redisTemplate.opsForValue().get(Constants.TOTAL_BID_MONEY);
        if (totalBidMoney == null){
            synchronized (this){
                totalBidMoney = bidInfoMapper.selectTotalBidMoney();
                redisTemplate.opsForValue().set(Constants.TOTAL_BID_MONEY,totalBidMoney,20, TimeUnit.MINUTES);
            }
        }
        return totalBidMoney;
    }

    /**
     *  查询产品的购买人等信息
     * @param id   产品的id
     * @return  返回自定义类
     */
    @Override
    public List<UserBidInfo> queryLoanRecordBidInfo(Integer id) {
        List<UserBidInfo> userBidInfos = bidInfoMapper.selectBidRecords(id);
        return userBidInfos;
    }

}
