package com.ly.service;

import com.ly.bean.OrderItem;

/**
 * @Author : Ly
 * @Date : 2022/5/10
 * @Description :
 */
public interface OrderItemService {
    /**
     * 保存订单项
     * @param orderItem 订单项
     * @return true：保存成功；false：保存失败
     */
    boolean saveOrderItem(OrderItem orderItem);

    /**
     * 根据订单号查询对应订单项信息查询
     * @param oderId 订单号id
     * @return 查询到的订单项
     */
    OrderItem queryOrderItemsByOrderId(String oderId);
}
