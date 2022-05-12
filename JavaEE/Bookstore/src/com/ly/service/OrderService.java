package com.ly.service;

import com.ly.bean.Cart;
import com.ly.bean.Order;

import java.util.List;

/**
 * @Author : Ly
 * @Date : 2022/5/10
 * @Description :
 */
public interface OrderService {
    /***
     * 保存用户提交的订单
     * @param order 订单
     * @return true：保存成功；false：保存失败
     */
    boolean saveOrder(Order order);

    /**
     * 查询所有订单(管理员使用)
     * @return 返回所有订单的集合
     */
    List<Order> queryOrder();

    /**
     * 修改订单状态
     * @param orderId 订单号
     * @param status 0：未发货，1：已发货，2：已签收
     * @return 修改是否成功，true：成功；false：失败
     */
    boolean updateOrderStatus(String orderId,int status);

    /**
     * 查询某个用户下的所有订单
     * @param userId 用户id
     * @return 该用户下所有订单的集合
     */
    List<Order> queryOrderByUserid(int userId);
}
