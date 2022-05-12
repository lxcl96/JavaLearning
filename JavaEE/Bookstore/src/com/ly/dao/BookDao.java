package com.ly.dao;

import com.ly.bean.Book;
import java.util.List;
import java.math.BigDecimal;

/**
 * @Author : Ly
 * @Date : 2022/5/2
 * @Description : 每个表都有对应的接口dao，用来规范方法
 */
public interface BookDao {

    /**
     * 根据图书价格查询图书
     * @param lowPrice 价格下线
     * @param highPrice  价格上限
     * @param currentPage 当前页 用于分页
     * @param number 每页显示的数量
     * @return 返回图书对象集合，如果没有返回null
     */
    public List<Book> queryByPrice(BigDecimal lowPrice,BigDecimal highPrice,int currentPage, int number);

    /**
     * 增加图书信息
     * @param book 图书对象
     * @return 1，成功；0，失败
     */
    public int addBook(Book book);

    /**
     * 根据图书id删除图书信息
     * @param id 图书id
     * @return 1，成功；0，失败
     */
    public int delBook(Integer id);

    /**
     * 更新图书信息
     * @param book 图书对象
     * @return 1，成功；0，失败
     */
    public int update(Book book);

    /**
     * 根据图书id查询图书信息
     * @param id 图书id
     * @return null，代表没有；否则返回一个Book对象
     */
    public Book queryById(Integer id);

    /**
     * 查询数据库中所有有效图书信息
     * @return 所有图书信息集合，否则返回空集合
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
     * 求数据库中所有有效数据的个数
     * @return 个数
     */
    public int queryPages();

    /**
     * 求数据库中指定价格区间所有有效数据的个数
     * @param lowPrice 价格下线
     * @param highPrice 价格上限
     * @return 个数
     */
    public int queryPagesByPrice(BigDecimal lowPrice,BigDecimal highPrice);
}
