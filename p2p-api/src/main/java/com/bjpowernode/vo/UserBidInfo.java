package com.bjpowernode.vo;

import com.bjpowernode.domain.BidInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author 侯旭东
 * @version 1.0
 * @date 2020/12/5 22:49
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserBidInfo extends BidInfo implements Serializable {
    private static final long serialVersionUID = -5736932899842289831L;
    private String phone;

}
