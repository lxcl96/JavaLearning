package com.ly.bean;

import java.math.BigDecimal;

/**
 * @Author : Ly
 * @Date : 2022/5/9
 * @Description : 购物车商品模型【一个商品】
 */
public class Goods {
    private Integer goodsId;
    private String goodsName;
    private Integer goodsCount;
    private BigDecimal goodsPrice;
    private BigDecimal goodsTotalPrice;

    public Goods() {
    }

    public Goods(Integer goodsId, String goodsName, Integer goodsCount, BigDecimal goodsPrice, BigDecimal goodsTotalPrice) {
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.goodsCount = goodsCount;
        this.goodsPrice = goodsPrice;
        this.goodsTotalPrice = goodsTotalPrice;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
    }

    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public BigDecimal getGoodsTotalPrice() {
        return goodsTotalPrice;
    }

    public void setGoodsTotalPrice(BigDecimal goodsTotalPrice) {
        this.goodsTotalPrice = goodsTotalPrice;
    }

    @Override
    public String toString() {
        return "CartItems{" +
                "goodsId=" + goodsId +
                ", goodsName='" + goodsName + '\'' +
                ", goodsCount=" + goodsCount +
                ", goodsPrice=" + goodsPrice +
                ", goodsTotalPrice=" + goodsTotalPrice +
                '}';
    }
}
