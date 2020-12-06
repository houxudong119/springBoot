package com.bjpowernode;

/**
 * @author 侯旭东
 * @version 1.0
 * @date 2020/12/4 16:32
 */
public class Constants {
    //年利率
    public static final String YEAR_RATE = "LOAN:RATE:DOUBLE";
    //平台总用户人数
    public static final String COUNT_USER = "USER:COUNT:INT";
    //请求成功
    public static final Integer SUCCESS = 0;
    //请求失败
    public static final Integer FAILURE = 1;
    //平台累计成交金额
    public static final String TOTAL_BID_MONEY = "INCOME:BID:DOUBLE";
    //新手宝
    public static final Integer NEW_LOAN = 0;
    //优选
    public static final Integer OPTIMIZATION_LOAN = 1;
    //散标
    public static final Integer SEPARATE_LOAN = 2;
    //指定进入产品详情页时的每页展示个数
    public static final Integer SHOW_TOTAL_SIZE = 9;
}
