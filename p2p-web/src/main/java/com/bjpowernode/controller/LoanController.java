package com.bjpowernode.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bjpowernode.Constants;
import com.bjpowernode.PageInfo;
import com.bjpowernode.domain.LoanInfo;
import com.bjpowernode.service.BidInfoService;
import com.bjpowernode.service.LoanInfoService;
import com.bjpowernode.vo.UserBidInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author 侯旭东
 * @version 1.0
 * @date 2020/12/5 21:48
 */
@Controller
public class LoanController {
    @Reference(interfaceClass = LoanInfoService.class,check = false,version = "1.0")
    LoanInfoService loanInfoService;
    @Reference(interfaceClass = BidInfoService.class,check = false,version = "1.0")
    BidInfoService bidInfoService;
    @RequestMapping("/loan/loan")
    public String loan(@RequestParam("ptype") Integer productType,
                       @RequestParam(value = "pageNo",
                               required = false,defaultValue = "1") Integer pageNo,
                       Model model){
        int offset = (pageNo - 1) * Constants.SHOW_TOTAL_SIZE;
        //通过产品类型查询产品分页展示9个
        List<LoanInfo> loanInfos = loanInfoService.queryLoanByTypePage(productType,
                offset,Constants.SHOW_TOTAL_SIZE);
        //查询产品
        Integer totalRows = loanInfoService.countLoanByTypeForPage(productType);
        PageInfo info = new PageInfo();
        info.setPageNo(pageNo);
        info.setPageSize(Constants.SHOW_TOTAL_SIZE);
        info.setTotalRows(totalRows);

        model.addAttribute("pageInfo",info);
        model.addAttribute("productType",productType);
        //产品信息
        model.addAttribute("loanInfos",loanInfos);
        return "loan";
    }

    /**
     *  通过id查询某个产品的详细信息
     * @param id 产品的id
     * @return 返回某个产品的详细信息
     */
    @RequestMapping("/loan/loanInfo")
    public String loanInfo(Integer id,Model model){
        LoanInfo loanInfo = loanInfoService.queryDetailLoanById(id);

        List<UserBidInfo> userBidInfos = bidInfoService.queryLoanRecordBidInfo(id);

        model.addAttribute("loanInfo",loanInfo);
        model.addAttribute("userBidInfos",userBidInfos);
        return "loanInfo";
    }
}
