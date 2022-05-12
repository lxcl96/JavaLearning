package com.ly.web;

import com.ly.bean.Book;
import com.ly.bean.Cart;
import com.ly.bean.Goods;
import com.ly.service.BookService;
import com.ly.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author : Ly
 * @Date : 2022/5/9
 * @Description : 购物车模块
 */
public class CartServlet extends BaseServlet{
    private BookService bookService = new BookServiceImpl();
    private Cart cart = new Cart();

    //添加到购物车
    protected void goodsAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取商品id
        String goodsId = req.getParameter("goodsId");
        //从数据库中查询到图书信息，转化为Goods对象
        Book book = bookService.queryBookById(Integer.parseInt(goodsId));
        Goods goods = new Goods(book.getId(), book.getBookName(), 1, book.getPrice(), book.getPrice());
        //加入购物车
       cart.goodsAdd(goods);
        //将购物车放在session中，并保存最新一次保存图书信息用于回显
        req.getSession().setAttribute("cart",cart);
        req.getSession().setAttribute("latestGoods",goods.getGoodsName());
        //返回商品列表 重定向[那么request域也变了，因此可以记录客户端传来的地址，直接重定向到该地址即可]
        //req.getHeader("Referer") 记录请求地址
        //System.out.println(req.getHeader("Referer"));
        resp.sendRedirect(req.getHeader("Referer"));
        System.out.println("商品添加成功");
    }

    //删除购物车指定商品
    protected void goodsDel(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取商品id
        String goodsId = req.getParameter("goodsId");
        Cart cart = (Cart)req.getSession().getAttribute("cart");
        if (cart != null && goodsId != null) {
            cart.goodsDel(Integer.parseInt(goodsId));
            //返回购物车 两种方式：1、直接返回原地址  Referer；
            // 2、相对路径
            resp.sendRedirect(req.getContextPath() + "/pages/cart/cart.jsp");
            System.out.println("商品删除成功");
        }
    }

    //清空购物车
    protected void cartClean(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart)req.getSession().getAttribute("cart");
        if (cart != null) {
            cart.cartClean();
            System.out.println("清空购物车成功！");
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    //修改指定商品数量
    protected void goodsNumAlter(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String goodsCount = req.getParameter("goodsCount");
        String goodsId = req.getParameter("goodsId");
        Cart cart = (Cart)req.getSession().getAttribute("cart");
        if (cart != null && goodsId != null) {
            cart.goodsNumAlter(Integer.parseInt(goodsId),Integer.parseInt(goodsCount));
            System.out.println("修改购物商品 数量成功！goodsId=" + goodsId + ",goodsCount="+ goodsCount);
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }
}
