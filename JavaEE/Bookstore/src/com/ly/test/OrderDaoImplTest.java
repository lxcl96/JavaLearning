package com.ly.test;

import com.ly.bean.Order;
import com.ly.dao.impl.OrderDaoImpl;
import com.ly.dao.impl.OrderItemDaoImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author : Ly
 * @Date : 2022/5/10
 * @Description :
 */
public class OrderDaoImplTest {
    OrderDaoImpl orderDao = new OrderDaoImpl();
    @Test
    public void saveOrder() {
        orderDao.saveOrder(new Order("2", new Date(), new BigDecimal(188.2), 2));
        orderDao.saveOrder(new Order("3", new Date(), new BigDecimal(88), 2));
        orderDao.saveOrder(new Order("4", new Date(), new BigDecimal(99), 2));

    }

    @Test
    public void queryOrder() {
        List<Order> orders = orderDao.queryOrder();
        OrderItemDaoImpl orderItemDao = new OrderItemDaoImpl();
        for (Order order : orders) {
            System.out.println(order + "------" + orderItemDao.queryOrderItemsByOrderId(order.getOrderId()));
        }
    }

    @Test
    public void updateOrderStatus() {
        orderDao.updateOrderStatus("1",2);
    }

    @Test
    public void queryOrderByUserid() {
        List<Order> orders = orderDao.queryOrderByUserid(2);
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}