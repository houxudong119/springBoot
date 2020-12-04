package com.bjpowernode.mapper;

import com.bjpowernode.domain.BidInfo;

public interface BidInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BidInfo record);

    int insertSelective(BidInfo record);

    BidInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BidInfo record);

    int updateByPrimaryKey(BidInfo record);

    /**
     * 查询总成交金额
     * @return 返回的总成交金额
     */
    Double selectTotalBidMoney();
}