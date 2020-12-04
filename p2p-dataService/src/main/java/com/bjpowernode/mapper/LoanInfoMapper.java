package com.bjpowernode.mapper;

import com.bjpowernode.domain.LoanInfo;

public interface LoanInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LoanInfo record);

    int insertSelective(LoanInfo record);

    LoanInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LoanInfo record);

    int updateByPrimaryKey(LoanInfo record);

    /**
     * @return 返回年利率
     */
    Double selectRateAverAge();
}