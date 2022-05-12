package com.ly.web;

import com.ly.bean.*;
import com.ly.service.BookService;
import com.ly.service.OrderItemService;
import com.ly.service.OrderService;
import com.ly.service.impl.BookServiceImpl;
import com.ly.service.impl.OrderItemServiceImpl;
import com.ly.service.impl.OrderServiceImpl;
import com.ly.utils.JdbcUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.SimpleFormatter;

/**
 * @Author : Ly
 * @Date : 2022/5/10
 * @Description :
 */
public class OrderServlet extends BaseServlet{
    private OrderService orderService = new OrderServiceImpl();
    private OrderItemService orderItemService = new OrderItemServiceImpl();
    private BookService bookService = new BookServiceImpl();

    //保存订单
    protected void saveOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //判断是否已经登陆，如果没登录 跳转到登陆界面
        User user = (User)req.getSession().getAttribute("user");
        if (user == null) {
            resp.sendRedirect(req.getContextPath() + "/pages/user/login.jsp");
            return;
        }

        System.out.println("****当前订单线程名为：" + Thread.currentThread().getName());
        //获取购物车相关信息
        Cart cart = (Cart)req.getSession().getAttribute("cart");

        //将购物车信息转化为订单 [Order是总订单，orderItem是订单中的某一项]
        //保存总订单
        String id = "DDBH" + new SimpleDateFormat("yyyyMMddhhmmssSS").format(new Date()) + user.getId();
        Order order = new Order(id, new Date(), cart.getGTotalPrices(), user.getId());


        //通过过滤器TransactionFilter给所有的service层都加上事务管理 ，这样就不用一个一个写try-catch了
        boolean  retOrder = orderService.saveOrder(order);
        if (retOrder) {
            System.out.println("Order订单保存成功");
        }
        //保存订单中的每一项，在查看详情中展示 【为了防止出现结算出错，需要启动数据库事务+ThreadLocal方便回滚】
        /*
            而数据库事务的回滚需要使用同一个connection对象，因此就需要把connection放在ThreadLocal实例中，以便于获取
            因此所有的操作必须要要在所有的线程中。
         */

        Set<Map.Entry<Integer, Goods>> entries = cart.getGoodsList().entrySet();
        for (Map.Entry<Integer, Goods> entry : entries) {
            Goods goods = entry.getValue();
            OrderItem orderItem = new OrderItem(null, goods.getGoodsName(), goods.getGoodsCount(), goods.getGoodsPrice(), goods.getGoodsTotalPrice(), order.getOrderId());
            boolean retOrderItem = orderItemService.saveOrderItem(orderItem);
            if (retOrderItem) {
                System.out.println("OrderItem商品详情保存成功" + goods);
                //同时更新图书的销量和库存
                Book book = bookService.queryBookById(goods.getGoodsId());
                book.setSales(book.getSales() + goods.getGoodsCount());
                book.setStock(book.getStock() - goods.getGoodsCount());
                bookService.updateBook(book);
            } else {
                System.out.println("OrderItem商品详情保存失败" + goods);
            }

        }
        req.getSession().setAttribute("orderId",id);
        //调用api支付

        //成功
        resp.sendRedirect(req.getContextPath() + "/pages/cart/checkout.jsp");

    }

    //根据用户id查询订单 【普通用户】
    protected void queryOrderByUserid(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //判断是否已经登陆，如果没登录 跳转到登陆界面
        User user = (User)req.getSession().getAttribute("user");
        if (user == null) {
            resp.sendRedirect(req.getContextPath() + "/pages/user/login.jsp");
            return;
        }

        //根据用户id查询用户订单
        List<Order> orders = orderService.queryOrderByUserid(user.getId());
        //把该用户的订单保存到session彧中
        req.getSession().setAttribute("orderList",orders);

        req.getRequestDispatcher("/pages/order/order.jsp").forward(req,resp);
    }

    //查询所有订单 【管理员】
    protected void queryAllOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //判断是否已经登陆，如果没登录 跳转到登陆界面
        User user = (User)req.getSession().getAttribute("user");
        if (user == null) {
            resp.sendRedirect(req.getContextPath() + "/pages/user/login.jsp");
            return;
        }

        //根据用户id查询用户订单
        if (user.getId() == 1) {
            List<Order> orders = orderService.queryOrder();
            //把该用户的订单保存到session彧中
            req.getSession().setAttribute("orderList",orders);

            req.getRequestDispatcher("/pages/manager/order_manager.jsp").forward(req,resp);
        } else {
            //普通用户
            queryOrderByUserid(req,resp);
        }

    }

    //更新图书状态 【管理员】
    protected void updateOrderStatus(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //String goodsStatus = req.getParameter("goodsStatus");
        String orderId = req.getParameter("orderId");

        if (orderId != null) {
            boolean b = orderService.updateOrderStatus(orderId, 1);
            if (b) {
                System.out.println("发货成功！");
            } else {
                System.out.println("发货失败！");
            }

            resp.sendRedirect(req.getHeader("Referer"));
        } else {
            System.out.println("出错了！！");
        }

    }
}
