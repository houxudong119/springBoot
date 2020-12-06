package com.bjpowernode.mapper;

import com.bjpowernode.domain.LoanInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    /**
     * @param loan 产品的类型
     * @param pageNo   分页数
     * @param pageSize  个数
     * @return  产品
     */
    List<LoanInfo> selectLoanByTypePage(@Param("loan") Integer loan, @Param("pageNo") int pageNo, @Param("pageSize") int pageSize);
    /**
     * 通过产品类型查询总条数
     * @param productType 产品类型
     * @return  总记录条数
     */
    Integer selectCountLoanByTypeForPage(Integer productType);
}