package com.ly.web;

import com.ly.bean.Book;
import com.ly.service.BookService;
import com.ly.service.impl.BookServiceImpl;
import com.ly.utils.WebUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.DbUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @Author : Ly
 * @Date : 2022/5/5
 * @Description :
 */
public class BookServlet extends BaseServlet{

    private BookService bookService = new BookServiceImpl();
    /**
     * 增加图书
     * @param req request请求
     * @param resp response请求
     * @throws ServletException 异常
     * @throws IOException 异常
     */
    public void addBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Book newBook = new Book();
        //获取前段参数
        try {
//            BeanUtils.populate(newBook,req.getParameterMap());
            Book newBook = WebUtils.copyParamsToBean(req.getParameterMap(), new Book());
            //保存到数据库中
            int i = bookService.addBook(newBook);
            if (i != 1) {
                System.out.println("保存不成功");

            }
            //不能直接用请求转发（一次请求），否则如果用户 刷新一次的话就会重复提交表单，导致重复添加
            //req.getRequestDispatcher("/manager/bookServlet?action=queryBooks").forward(req,resp);
            //解决方法重定向 ，解决两次请求 【注：重定向从ip:port开始需要自己输入工程名】
            resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=queryPages");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除图书
     * @param req request请求
     * @param resp response请求
     * @throws ServletException 异常
     * @throws IOException 异常
     */
    public void delBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        System.out.println("要删除的图书id为“：" + id);
        int i = bookService.delBookById(Integer.parseInt(id));
        if (i == 1)
            System.out.println("删除成功！");
        //重定向，处理两次请求
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=queryPages");
    }

    /**
     * 更新图书
     * @param req request请求
     * @param resp response请求
     * @throws ServletException 异常
     * @throws IOException 异常
     */
    public void updateBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bookId = req.getParameter("bookId");
        try {
            Book bookInfoObj = WebUtils.copyParamsToBean(req.getParameterMap(),bookService.queryBookById(Integer.parseInt(bookId)));
            int i = bookService.updateBook(bookInfoObj);
            if (i == 1) {
                System.out.println("信息更新成功");
            }
            //重定向，处理两次请求
            resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=queryPages");
        } catch (InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }


    }

    /**
     * 图书列表查询===》分页显示
     * @param req request请求
     * @param resp response请求
     * @throws ServletException 异常
     * @throws IOException 异常
     */
    public void queryBooks(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> books = bookService.queryBooks();
        req.setAttribute("bookList",books);

        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);
    }

    /**
     * 获取jsp页面数据传递到修改页面
     * @param req request请求
     * @param resp response请求
     * @throws ServletException 异常
     * @throws IOException 异常
     */
    public void bookInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bookInfoId = req.getParameter("bookInfoId");
        Book bookInfoObj = bookService.queryBookById(Integer.parseInt(bookInfoId));
        req.setAttribute("bookInfoObj",bookInfoObj);
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req,resp);
    }


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
            number = 10;
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
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);
    }
}
