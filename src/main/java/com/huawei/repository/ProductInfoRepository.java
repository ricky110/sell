package com.huawei.repository;

import com.huawei.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 商品
 * @Author: Ricky
 * @Date: 2019-09-23 11:25
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo,String> {
    List<ProductInfo> findByProductStatus(Integer categoryStatus);
}
