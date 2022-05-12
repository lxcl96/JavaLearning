package com.ly.dao.impl;

import com.ly.bean.OrderItem;
import com.ly.dao.OrderItemDao;

/**
 * @Author : Ly
 * @Date : 2022/5/10
 * @Description :订单项Dao实现类
 */
public class OrderItemDaoImpl extends BaseDao<OrderItem> implements OrderItemDao {
    @Override
    public boolean saveOrderItem(OrderItem orderItem) {
        System.out.println("****当前订单线程名为：" + Thread.currentThread().getName());
        String sql = "insert into t_order_item values(?,?,?,?,?,?);";
        return update(sql,orderItem.getId(),orderItem.getName(),orderItem.getCount(),orderItem.getPrice(),orderItem.getTotalPrice(),orderItem.getOrderId()) == 1;
    }

    @Override
    public OrderItem queryOrderItemsByOrderId(String oderId) {
        String sql = "select * from t_order_item where orderId=?";
        return selectSingle(sql,OrderItem.class,oderId);
    }
}
