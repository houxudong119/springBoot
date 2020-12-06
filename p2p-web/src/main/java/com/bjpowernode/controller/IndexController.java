package com.bjpowernode.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bjpowernode.Constants;
import com.bjpowernode.IndexData;
import com.bjpowernode.Result;
import com.bjpowernode.domain.LoanInfo;
import com.bjpowernode.service.BidInfoService;
import com.bjpowernode.service.LoanInfoService;
import com.bjpowernode.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author 侯旭东
 * @version 1.0
 * @date 2020/12/4 16:25
 */
@Controller
public class IndexController {
    @Reference(interfaceClass = LoanInfoService.class,check = false,version = "1.0")
    private LoanInfoService loanInfoService;
    @Reference(interfaceClass = UserService.class,check = false,version = "1.0")
    private UserService userService;
    @Reference(interfaceClass = BidInfoService.class,check = false,version = "1.0")
    private BidInfoService bidInfoService;

    @RequestMapping(value = {"/","/index"})
    public String index(Model model){
        //查询数据库获取年利率
        Double rateAverage = loanInfoService.queryRateAverage();
        //查询平台用户数
        Integer users = userService.queryCountUser();
        //累计成交额
        Double totalBidMoney = bidInfoService.queryTotalBidMoney();
        //查询新手宝的信息
        List<LoanInfo> loanInfos =  loanInfoService.queryLoanByTypePage(Constants.NEW_LOAN,0,1);
        model.addAttribute("newLoans",loanInfos);
        //查询优选
        loanInfos =  loanInfoService.queryLoanByTypePage(Constants.OPTIMIZATION_LOAN,0,4);
        model.addAttribute("optimizations",loanInfos);
        //查询散标
        loanInfos =  loanInfoService.queryLoanByTypePage(Constants.SEPARATE_LOAN,0,8);
        model.addAttribute("separates",loanInfos);

        //调用用于返回结果信息的类
        Result result = new Result().buildSuccess("成功");
        //创建一个首页数据类
        IndexData data = new IndexData();
        //修改年利率
        data.setRateAverage(rateAverage);
        //修改平台总人数
        data.setCountUser(users);
        //修改总成交额
        data.setTotalBidMoney(totalBidMoney);
        //修改返回信息类的属性
        result.setIndexData(data);
        model.addAttribute("result",result);
        return "index";
    }


}
