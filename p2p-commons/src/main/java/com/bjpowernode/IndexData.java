package com.bjpowernode;

import lombok.Data;

/**
 * @author 侯旭东
 * @version 1.0
 * @date 2020/12/4 17:15
 */
@Data
public class IndexData {
    //平台年利率
    private Double rateAverage;
    //平台全部交易的金额
    private Double totalBidMoney;
    //平台全部的用户
    private Integer countUser;

}
