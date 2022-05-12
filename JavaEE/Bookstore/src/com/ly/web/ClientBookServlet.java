package com.ly.web;

import com.ly.bean.Book;
import com.ly.service.BookService;
import com.ly.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

/**
 * @Author : Ly
 * @Date : 2022/5/7
 * @Description : 实现首页跳转，因此首页只是用来跳转到指定的页面（为了实现分页功能）
 */
public class ClientBookServlet extends BaseServlet{
    private BookService bookService = new BookServiceImpl();
    /**
     * 根据前端请求，处理分页信息
     * @param req request请求
     * @param resp response请求
     */
    public void queryPages(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int currentPage = -1;
        int number = -1;

        //1、获取请求参数，当前页初始值为1，和每页显示的数据默认为10
        try {
            currentPage = Integer.parseInt(req.getParameter("currentPage")); //当前页数
        } catch (NumberFormatException e) { //第一次进入 没有找到参数
            currentPage = 1;
        }

        try {
            number = Integer.parseInt(req.getParameter("number")); //每页显示的数据
        } catch (NumberFormatException e) { //第一次进入 没有找到参数
            number = 4;
        }
        //总记录数
        int total = bookService.queryPages();
        //共多少页
        int pageNum = total / number;
        if (total % number != 0) {
            pageNum++;
        }
        //判断前端传参值 不在页数范围内
        if (currentPage < 1) {
            currentPage = 1;
        }
        if (currentPage > pageNum) {
            currentPage = pageNum;
        }
        //2、调用BookServiceImpl.queryPage(int pageNo, int number);方法  (pageNo - 1) * number代表其实记录数，number代表数量
        List<Book> books = bookService.queryPage((currentPage - 1) * number, number);

        //3、把查询数据保存到request彧中
        req.setAttribute("bookList",books);
        req.setAttribute("total",total);
        req.setAttribute("currentPage",currentPage);
        req.setAttribute("number",number);
        req.setAttribute("pageNum",pageNum);//共多少页
        //4、请求转发到book_manager.jsp页面
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);
    }


    /**
     * 根据价格筛选图书，并且分页显示
     * @param req request请求
     * @param resp response请求
     */
    public void queryPagesByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int currentPage = -1;
        int number = -1;


        //获取价格区间
        String min = req.getParameter("min");
        String max = req.getParameter("max");

        //设置在request域中，便于网页获取
        req.setAttribute("min",Integer.parseInt(min));
        req.setAttribute("max",Integer.parseInt(max));
        //1、获取请求参数，当前页初始值为1，和每页显示的数据默认为4
        try {
            currentPage = Integer.parseInt(req.getParameter("currentPage")); //当前页数
        } catch (NumberFormatException e) { //第一次进入 没有找到参数
            currentPage = 1;
        }

        try {
            number = Integer.parseInt(req.getParameter("number")); //每页显示的数据
        } catch (NumberFormatException e) { //第一次进入 没有找到参数
            number = 4;
        }
        //总记录数
        int total = bookService.queryPagesByPrice(new BigDecimal(min),new BigDecimal(max));
        //共多少页
        int pageNum = total / number;
        if (total % number != 0) {
            pageNum++;
        }
        //判断前端传参值 不在页数范围内
        if (currentPage < 1) {
            currentPage = 1;
        }
        if (currentPage > pageNum) {
            currentPage = pageNum;
        }

        //2、调用BookServiceImpl.queryByPrice(int pageNo, int number);方法  (pageNo - 1) * number代表其实记录数，number代表数量
        List<Book> books = bookService.queryByPrice(new BigDecimal(min),new BigDecimal(max),(currentPage - 1) * number, number);

        //3、把查询数据保存到request彧中
        req.setAttribute("bookList",books);
        req.setAttribute("total",total);
        req.setAttribute("currentPage",currentPage);
        req.setAttribute("number",number);
        req.setAttribute("pageNum",pageNum);//共多少页
        //4、请求转发到book_manager.jsp页面
        req.getRequestDispatcher("/pages/client/priceQuery.jsp").forward(req,resp);
    }
}
