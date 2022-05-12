package com.ly.dao.impl;

import com.ly.bean.Order;
import com.ly.dao.OrderDao;

import java.util.List;

/**
 * @Author : Ly
 * @Date : 2022/5/10
 * @Description :订单Dao实现类
 */
public class OrderDaoImpl extends BaseDao<Order> implements OrderDao {
    @Override
    public boolean saveOrder(Order order) {
        System.out.println("****当前订单线程名为：" + Thread.currentThread().getName());
        String sql = "insert into t_order values(?,?,?,?,?);";
        return update(sql,order.getOrderId(),order.getCreateTime(),order.getPrice(),order.getStatus(),order.getUserid()) == 1;
    }

    @Override
    public List<Order> queryOrder() {
        String sql = "select * from t_order;";
        return selectMany(sql,Order.class);
    }

    @Override
    public boolean updateOrderStatus(String orderId, int status) {
        String sql = "update t_order set status=? where orderId=?;";
        return update(sql,status,orderId) == 1;
    }

    @Override
    public List<Order> queryOrderByUserid(int userId) {
        String sql = "select * from t_order where userid=?;";
        return selectMany(sql,Order.class,userId);
    }
}
