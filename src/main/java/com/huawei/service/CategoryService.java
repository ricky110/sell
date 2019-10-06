package com.huawei.service;

import com.huawei.dataobject.ProductCategory;

import java.util.List;

/**
 * 类目
 * @Author: Ricky
 * @Date: 2019-09-23 10:47
 */
public interface CategoryService {
    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}
