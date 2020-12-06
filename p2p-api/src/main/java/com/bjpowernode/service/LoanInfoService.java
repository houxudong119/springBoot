package com.bjpowernode.service;

import com.bjpowernode.domain.LoanInfo;

import java.util.List;

/**
 * @author 侯旭东
 * @version 1.0
 * @date 2020/12/4 16:28
 */

public interface LoanInfoService {
    /**
     * 查询年利率
     * @return 年利率
     */
    Double queryRateAverage();

    /**
     * @param loan 产品的类型 0新手宝 1优选 2散标
     * @param pageNo   产品的分页
     * @param pageSize  每页的数量
     * @return 产品的详细信息
     */
    List<LoanInfo> queryLoanByTypePage(Integer loan, int pageNo, int pageSize);

    /**
     * 通过产品类型查询总条数
     * @param productType 产品类型
     * @return  总记录条数
     */
    Integer countLoanByTypeForPage(Integer productType);

    /**查询商品的详情
     * @param id 产品的主键
     * @return 返回产品
     */
    LoanInfo queryDetailLoanById(Integer id);
}
