package com.bjpowernode.mapper;

import com.bjpowernode.domain.IncomeRecord;

public interface IncomeRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IncomeRecord record);

    int insertSelective(IncomeRecord record);

    IncomeRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IncomeRecord record);

    int updateByPrimaryKey(IncomeRecord record);

    /**
     *  查询累计成交金额
     * @return 返回累计的成交金额
     */
    Double selectTotalBidMoney();
}