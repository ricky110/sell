package com.huawei.enums;

import lombok.Getter;

/**
 * @Author: Ricky
 * @Date: 2019-10-06 16:43
 */
@Getter
public enum OrderStatusEnum {
    NEW(0,"新订单"),
    FINISHED(1,"完结"),
    CANCEL(2,"已取消"),
    ;

    private Integer code;

    private String message;


    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
