package com.huawei.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 商品详情   （** 此类跟ProductInfo的区别是此类仅仅包含需要传给前端的字段，为了保护隐私 **）
 * @Author: Ricky
 * @Date: 2019-09-23 15:34
 */
@Data
public class ProductInfoVO {

    @JsonProperty("id")
    private String productId;

    @JsonProperty("name")
    private String productName;

    @JsonProperty("price")
    private BigDecimal productPrice;

    @JsonProperty("description")
    private String productDescription;

    @JsonProperty("icon")
    private String productIcon;

}
