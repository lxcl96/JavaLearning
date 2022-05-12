package com.ly.bean;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author : Ly
 * @Date : 2022/5/10
 * @Description : 订单数据模型对应数据库的t_order表
 */
public class Order {
    private String orderId;
    private Date createTime;
    private BigDecimal price;
    //默认值为0，0：未发货，1：已发货，2：已签收
    private Integer status = 0;
    private Integer userid;

    public Order() {
    }

    public Order(String orderId, Date createTime, BigDecimal price, Integer userid) {
        this.orderId = orderId;
        this.createTime = createTime;
        this.price = price;
        this.userid = userid;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", createTime=" + createTime +
                ", price=" + price +
                ", status=" + status +
                ", userid=" + userid +
                '}';
    }
}
