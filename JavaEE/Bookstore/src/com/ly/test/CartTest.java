package com.ly.test;

import com.ly.bean.Cart;
import com.ly.bean.Goods;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @Author : Ly
 * @Date : 2022/5/9
 * @Description :
 */
public class CartTest {
    static Cart cart = new Cart();
    static {
        cart.goodsAdd(new Goods(1,"Java从入门到放弃1",1,new BigDecimal(100),new BigDecimal(100)));
        cart.goodsAdd(new Goods(2,"Java从入门到放弃2",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.goodsAdd(new Goods(3,"Java从入门到放弃3",1,new BigDecimal(900),new BigDecimal(900)));
        cart.goodsAdd(new Goods(4,"Java从入门到放弃4",1,new BigDecimal(500),new BigDecimal(500)));
    }
    @Test
    public void goodsAdd() {
        cart.goodsAdd(new Goods(4,"Java从入门到放弃4",1,new BigDecimal(500),new BigDecimal(500)));
        System.out.println(cart);
    }

    @Test
    public void goodsDel() {
        cart.goodsDel(4);
        System.out.println(cart);
    }

    @Test
    public void cartClean() {
        cart.cartClean();
        System.out.println(cart);
    }

    @Test
    public void goodsNumAlter() {
        cart.goodsNumAlter(4,2);
        System.out.println(cart);
    }
}