package com.ly.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author : Ly
 * @Date : 2022/5/9
 * @Description : 购物车总结模型[总商品]
 */
public class Cart {
    private Integer TotalCount = 0;
    private BigDecimal GTotalPrices = new BigDecimal(0);
    private Map<Integer,Goods> goodsList = new LinkedHashMap<>();//购物车里的所有商品

    public Cart() {
    }

    public Cart(Integer totalCount, BigDecimal GTotalPrices, Map<Integer,Goods> goodsList) {
        TotalCount = totalCount;
        this.GTotalPrices = GTotalPrices;
        this.goodsList = goodsList;
    }

    public Integer getTotalCount() {
        return TotalCount;
    }

    public void setTotalCount(Integer totalCount) {
        TotalCount = totalCount;
    }

    public BigDecimal getGTotalPrices() {
        return GTotalPrices;
    }

    public void setGTotalPrices(BigDecimal GTotalPrices) {
        this.GTotalPrices = GTotalPrices;
    }

    public Map<Integer,Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(Map<Integer,Goods> goodsList) {
        this.goodsList = goodsList;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "TotalCount=" + TotalCount +
                ", GTotalPrices=" + GTotalPrices +
                ", goodsList=" + goodsList +
                '}';
    }

    /**
     * 添加商品到购物车中,注意第一次之后是数量少的累加
     * @param targetGoods 要添加的商品
     */
    public void goodsAdd(Goods targetGoods){
        Goods goods = goodsList.get(targetGoods.getGoodsId());
        if (goods == null) {
            goodsList.put(targetGoods.getGoodsId(),targetGoods);
        } else {
            goods.setGoodsCount(goods.getGoodsCount() + 1);
            goods.setGoodsTotalPrice(goods.getGoodsPrice().multiply(new BigDecimal(goods.getGoodsCount())));
        }
        this.setTotalCount(this.getTotalCount() + 1);
        this.setGTotalPrices(this.getGTotalPrices().add(targetGoods.getGoodsPrice()));
    }

    /**
     * 删除商品
     * @param targetGoodsId 商品id
     */
    public void goodsDel(Integer targetGoodsId) {
        Goods goods = goodsList.get(targetGoodsId);
        if (goods != null) {
            this.setTotalCount(this.getTotalCount() - goods.getGoodsCount());
            this.setGTotalPrices(this.getGTotalPrices().subtract(goods.getGoodsTotalPrice()));
            //参数为key
            goodsList.remove(targetGoodsId);
        }
    }

    /**
     * 清空购物车
     */
    public void cartClean() {
        goodsList.clear();
        this.setTotalCount(0);
        this.setGTotalPrices(new BigDecimal(0));
    }

    /**
     * 修改商品数量
     * @param targetGoodsId 商品id
     * @param count 商品数量
     */
    public void goodsNumAlter(Integer targetGoodsId,Integer count) {
        Goods goods = goodsList.get(targetGoodsId);
        if (goods != null) {
            this.setTotalCount(this.getTotalCount() + count - goods.getGoodsCount());
            this.setGTotalPrices(this.getGTotalPrices().subtract(goods.getGoodsTotalPrice()).add(goods.getGoodsPrice().multiply(new BigDecimal(count))));
            goods.setGoodsCount(count);
            goods.setGoodsTotalPrice(goods.getGoodsPrice().multiply(new BigDecimal(count)));
        }
    }
}
