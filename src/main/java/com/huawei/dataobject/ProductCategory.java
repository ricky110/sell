package com.huawei.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.Date;

/**
 * 类目
 * @Author: Ricky
 * @Date: 2019-09-22 22:01
 */

// 如果表名(eg:s_product_category)和类名不一致可以使用 @Table
//    @Table(name = "s_product_category")

    // @Entity 将数据库映射成类对象
    // @Proxy 加上，要不然使用 getOne() 会报错
    //org.hibernate.LazyInitializationException: could not initialize proxy [com.huawei.dataobject.ProductCategory#1] - no Session

    // @DynamicUpdate  动态更新 会更新数据的更新时间

    // @Data 包括类的getter setter toString 方法  既类可以省略这些方法不写
    @Entity
    @Proxy(lazy = false)
    @DynamicUpdate
    @Data
public class ProductCategory {

    /** 类目id
     * @Id 主键
     * @GeneratedValue 自增类型的
     *
     * strategy = GenerationType.IDENTITY  不加这个 测试中 save 插入数据会报错
     * */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    /** 类目名字 */
    private String categoryName;

    /** 类目编号 */
    private Integer categoryType;

    private Date createTime;

    private Date updateTime;

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }

    public ProductCategory() {
    }
}
