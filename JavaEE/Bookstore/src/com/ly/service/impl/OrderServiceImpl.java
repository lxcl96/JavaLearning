package com.ly.service.impl;

import com.ly.bean.Order;
import com.ly.dao.OrderDao;
import com.ly.dao.impl.OrderDaoImpl;
import com.ly.service.OrderService;

import java.util.List;

/**
 * @Author : Ly
 * @Date : 2022/5/10
 * @Description :
 */
public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao = new OrderDaoImpl();
    @Override
    public boolean saveOrder(Order order) {
        //System.out.println("****当前订单线程名为：" + Thread.currentThread().getName());
       return orderDao.saveOrder(order);
    }

    @Override
    public List<Order> queryOrder() {
       return orderDao.queryOrder();
    }

    @Override
    public boolean updateOrderStatus(String orderId, int status) {
        return orderDao.updateOrderStatus(orderId,status);
    }

    @Override
    public List<Order> queryOrderByUserid(int userId) {
        return orderDao.queryOrderByUserid(userId);
    }
}
