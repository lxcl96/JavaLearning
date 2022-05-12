package com.ly.service.impl;

import com.ly.bean.Book;
import com.ly.dao.BookDao;
import com.ly.dao.impl.BookDaoImpl;
import com.ly.service.BookService;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author : Ly
 * @Date : 2022/5/3
 * @Description : BookService实现类
 */
public class BookServiceImpl implements BookService {
    private BookDao bookDao = new BookDaoImpl();
    @Override
    public int addBook(Book book) {
        return bookDao.addBook(book);
    }

    @Override
    public int delBookById(Integer id) {
        return bookDao.delBook(id);
    }

    @Override
    public int updateBook(Book book) {
        return bookDao.update(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }

    @Override
    public List<Book> queryPage(int currentPage, int number) {
        return bookDao.queryPage(currentPage, number);
    }

    @Override
    public int queryPages() {
        return bookDao.queryPages();
    }

    @Override
    public List<Book> queryByPrice(BigDecimal lowPrice, BigDecimal highPrice, int currentPage, int number) {
        return bookDao.queryByPrice(lowPrice,highPrice,currentPage,number);
    }

    @Override
    public int queryPagesByPrice(BigDecimal lowPrice, BigDecimal highPrice) {
        return bookDao.queryPagesByPrice(lowPrice,highPrice);
    }


}
