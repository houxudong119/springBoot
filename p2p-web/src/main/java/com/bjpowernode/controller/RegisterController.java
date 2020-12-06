package com.bjpowernode.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bjpowernode.Constants;
import com.bjpowernode.ErrorCode;
import com.bjpowernode.Result;
import com.bjpowernode.domain.User;
import com.bjpowernode.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.regex.Pattern;

/**
 * @author 侯旭东
 * @version 1.0
 * @date 2020/12/6 9:41
 */
@Controller
public class RegisterController {
    @Reference(interfaceClass = UserService.class,check = false,version = "1.0")
    private UserService userService;

    @RequestMapping("/loan/page/register")
    public String register(){
        return "register";
    }


    @RequestMapping("/loan/checkPhone")
    public @ResponseBody Result checkPhone(String phone){
        String text = "^1[1-9]\\\\d{9}$";
        Result result = new Result();
        if ( Pattern.compile(text).matcher(phone).matches()){
            result.setCode(Constants.FAILURE);
            result.setError(ErrorCode.ERROR);
            result.setMessage("越狱手机号格式错误，或正则表达式错误");
        }else{
            User user = userService.queryUserByPhone(phone);
            result.setCode(Constants.SUCCESS);
            //user是空说明数据库没有这个手机号可以注册
            if (user == null){
                result.setError(ErrorCode.NO_ERROR);
                result.setMessage("可以注册");
            }else{
                result.setError(ErrorCode.ERROR);
                result.setMessage("手机号已存在，请检查后重试");
            }
        }
        return result;
    }
}
