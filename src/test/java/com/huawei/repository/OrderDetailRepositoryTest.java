package com.huawei.repository;

import com.huawei.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: Ricky
 * @Date: 2019-10-06 22:51
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void saveTest() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("12345678");
        orderDetail.setOrderId("11111");
        orderDetail.setProductIcon("http://xxx.jpg");
        orderDetail.setProductId("1111122");
        orderDetail.setProductName("皮蛋粥");
        orderDetail.setProductPrice(new BigDecimal(3.3));
        orderDetail.setProductQuantity(2);

        OrderDetail result =  repository.save(orderDetail);
        Assert.assertNotNull(result);


    }

    @Test
    public void findByOrderId() {
       List<OrderDetail> orderDetailList = repository.findByOrderId("11111");
       Assert.assertNotEquals(0, orderDetailList.size());
    }

    /**
     * 根据方法名字生成SQL语句
     */
    @Test
    public void findByDetailId() {

        List<OrderDetail> orderDetailList = repository.findByDetailId("12345678");
        Assert.assertNotEquals(0, orderDetailList.size());

    }
}