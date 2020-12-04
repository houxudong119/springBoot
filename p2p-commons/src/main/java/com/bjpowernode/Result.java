package com.bjpowernode;

import lombok.Data;

/**
 * @author 侯旭东
 * @version 1.0
 * @date 2020/12/4 17:12
 */
@Data
public class Result {
    //本次请求的处理结果
    private Integer code;
    private Integer error;
    private String message;
    private IndexData indexData;

    public Result buildSuccess(String message){
        this.code = Constants.SUCCESS;
        this.error = ErrorCode.NO_ERROR;
        this.message = message;
        return this;
    }
}
