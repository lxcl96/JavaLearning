package com.ly.service.impl;

import com.ly.bean.OrderItem;
import com.ly.dao.OrderItemDao;
import com.ly.dao.impl.OrderItemDaoImpl;
import com.ly.service.OrderItemService;

/**
 * @Author : Ly
 * @Date : 2022/5/10
 * @Description :
 */
public class OrderItemServiceImpl implements OrderItemService {
    private OrderItemDao orderItemDao = new OrderItemDaoImpl();
    @Override
    public boolean saveOrderItem(OrderItem orderItem) {
        System.out.println("****当前订单线程名为：" + Thread.currentThread().getName());
        return orderItemDao.saveOrderItem(orderItem);
    }

    @Override
    public OrderItem queryOrderItemsByOrderId(String oderId) {
        return orderItemDao.queryOrderItemsByOrderId(oderId);
    }
}
