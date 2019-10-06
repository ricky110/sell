package com.huawei.repository;

import com.huawei.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: Ricky
 * @Date: 2019-10-06 17:12
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail,String> {
    /**
     * 订单头表（Master）中的第一条数据可能对应订单详情表（Detail）中的多条数据
     */
    List<OrderDetail> findByOrderId(String orderId);
    List<OrderDetail> findByDetailId(String detailId);
}
