package com.bjpowernode.mapper;

import com.bjpowernode.domain.BidInfo;
import com.bjpowernode.vo.UserBidInfo;

import java.util.List;

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

    /**
     * 查询投资记录
     * @param id 产品的id
     * @return  返回详细信息
     */
    List<UserBidInfo> selectBidRecords(Integer id);
}