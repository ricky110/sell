package com.huawei.enums;

import lombok.Getter;

/**
 * 商品状态
 * @Author: Ricky
 * @Date: 2019-09-23 12:38
 */
@Getter
public enum ProductStatusEnum {

    UP(0,"在架"),
    DOWN(1,"下架")
    ;

    private Integer code;

    private String message;

    ProductStatusEnum(Integer code, String message) {

        this.code = code;
        this.message = message;
    }
}
