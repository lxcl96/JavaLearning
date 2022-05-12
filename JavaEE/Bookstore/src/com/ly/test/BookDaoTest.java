package com.ly.test;

import com.ly.bean.Book;
import com.ly.dao.impl.BookDaoImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author : Ly
 * @Date : 2022/5/3
 * @Description : BookDao的测试用例
 */
public class BookDaoTest {

    @Test
    public void queryByPrice() {
        BookDaoImpl bookDao = new BookDaoImpl();
        List<Book> books = bookDao.queryByPrice(new BigDecimal(50), new BigDecimal(100),0,10);
        for (Book book : books) {
            System.out.println(book);
        }
    }

    @Test
    public void addBook() {
        BookDaoImpl bookDao = new BookDaoImpl();
        int i = bookDao.addBook(new Book(null,"西游记",new BigDecimal(99),"吴承恩",3000,2,"static/img/default.jpg"));
        if (i == 1)
            System.out.println("新增图书成功！");
    }

    @Test
    public void delBook() {
        BookDaoImpl bookDao = new BookDaoImpl();
        int i = bookDao.delBook(21);
        if (i == 1)
            System.out.println("删除成功");
    }

    @Test
    public void update() {
        BookDaoImpl bookDao = new BookDaoImpl();
        Book book = bookDao.queryById(21);
        book.setBookName("Test哈哈哈");
        int update = bookDao.update(book);
        if (update == 1)
            System.out.println("更新图书信息成功！");
    }

    @Test
    public void queryById() {
        BookDaoImpl bookDao = new BookDaoImpl();
        Book book = bookDao.queryById(22);
        System.out.println(book);
    }

    @Test
    public void queryBooks() {
        List<Book> books = new BookDaoImpl().queryBooks();
        for (Book book : books) {
            System.out.println(book);
        }
    }

    @Test
    public void queryPages() {
        int i = new BookDaoImpl().queryPages();
        System.out.println(i);
    }
    @Test
    public void queryPage() {
        List<Book> books = new BookDaoImpl().queryPage(0, 10);
        for (Book book : books) {
            System.out.println(book);
        }
    }
}