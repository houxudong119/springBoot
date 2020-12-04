package com.bjpowernode.service;

/**
 * @author 侯旭东
 * @version 1.0
 * @date 2020/12/4 20:55
 */
public interface IncomeRecordService {
    /**
     *查询平台累计成交金额
     * @return 平台累计成交金额
     */
    Double queryTotalBidMoney();
}
