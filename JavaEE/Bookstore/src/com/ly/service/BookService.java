package com.ly.service;

import com.ly.bean.Book;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author : Ly
 * @Date : 2022/5/3
 * @Description : 图书模块
 */
public interface BookService {

    /**
     * 新增图书信息
     * @param book 图书对象
     * @return 1代表成功，0代表失败
     */
    public int addBook(Book book);

    /**
     * 根据id删除图书信息
     * @param id 图书id
     * @return 1代表成功，0代表失败
     */
    public int delBookById(Integer id);

    /**
     * 更新图书信息
     * @param book 图书对象
     * @return 1代表成功，0代表失败
     */
    public int updateBook(Book book);

    /**
     * 根据图书id查询图书信息
     * @param id 图书id
     * @return null代表没找到，
     */
    public Book queryBookById(Integer id);

    /**
     * 查询所有图书集合
     * @return 图书集合
     */
    public List<Book> queryBooks();

    /**
     * 处理前端传递分页数，和显示个数参数，实现分页
     * @param currentPage 第几页
     * @param number 每页显示的数量
     * @return Book对象集合
     */
    public List<Book> queryPage(int currentPage, int number);


    /**
     * 查询数据库所有有效的图书个数
     * @return 图书个数
     */
    public int queryPages();

    /**
     * 根据图书价格查询图书
     * @param lowPrice 价格下线
     * @param highPrice  价格上限
     * @param currentPage 当前页 用于分页
     * @param number 每页显示的数量
     * @return 返回图书对象集合，如果没有返回null
     */
    public List<Book> queryByPrice(BigDecimal lowPrice, BigDecimal highPrice, int currentPage, int number);


    /**
     * 求数据库中指定价格区间所有有效数据的个数
     * @param lowPrice 价格下线
     * @param highPrice 价格上限
     * @return 个数
     */
    public int queryPagesByPrice(BigDecimal lowPrice,BigDecimal highPrice);
}
