package com.ly.test;

import com.ly.bean.OrderItem;
import com.ly.dao.impl.OrderItemDaoImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @Author : Ly
 * @Date : 2022/5/10
 * @Description :
 */
public class OrderItemDaoImplTest {

    @Test
    public void saveOrderItem() {
        OrderItemDaoImpl orderItemDao = new OrderItemDaoImpl();
        orderItemDao.saveOrderItem(new OrderItem(2, "算法大全", 1, new BigDecimal(188.2), new BigDecimal(188.2), "2"));
        orderItemDao.saveOrderItem(new OrderItem(3, "三国", 1, new BigDecimal(88), new BigDecimal(88), "3"));
        orderItemDao.saveOrderItem(new OrderItem(4, "三国", 1, new BigDecimal(99), new BigDecimal(99), "4"));
    }

    @Test
    public void queryOrderItemsByOrderId() {
    }
}