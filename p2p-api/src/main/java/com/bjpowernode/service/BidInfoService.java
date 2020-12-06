package com.bjpowernode.service;

import com.bjpowernode.vo.UserBidInfo;

import java.util.List;

/**
 * @author 侯旭东
 * @version 1.0
 * @date 2020/12/4 21:14
 */
public interface BidInfoService {
    /**
     *查询平台累计成交金额
     * @return 平台累计成交金额
     */
    Double queryTotalBidMoney();

    /**
     *  查询产品的购买人等信息
     * @param id   产品的id
     * @return  返回自定义类
     */
    List<UserBidInfo> queryLoanRecordBidInfo(Integer id);
}
