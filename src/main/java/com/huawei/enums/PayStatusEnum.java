package com.huawei.enums;

import lombok.Getter;

/**
 * @Author: Ricky
 * @Date: 2019-10-06 16:49
 */
@Getter
public enum PayStatusEnum {

    WAIT(0, "等待支付"),
    SUCCESS(1, "支付成功"),
    ;
    private Integer code;
    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
