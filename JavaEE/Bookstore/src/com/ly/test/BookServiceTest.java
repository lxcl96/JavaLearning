package com.ly.test;

import com.ly.bean.Book;
import com.ly.service.BookService;
import com.ly.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author : Ly
 * @Date : 2022/5/3
 * @Description :
 */
public class BookServiceTest {
    private BookService bookService =  new BookServiceImpl();

    @Test
    public void addBook() {
        int i = bookService.addBook(new Book(null, "三国演义", new BigDecimal(199), "罗贯中", 3843424, 0, null));
        if (i == 1)
            System.out.println("插入成功");
    }

    @Test
    public void delBookById() {
        int i = bookService.delBookById(21);
        if (i == 1)
            System.out.println("删除成功");
    }

    @Test
    public void updateBook() {
        int i = bookService.updateBook(new Book(21, "test3", new BigDecimal(20), "test3", 1, 0, null));
        if (i == 1)
            System.out.println("更新图书信息成功");
    }

    @Test
    public void queryBookById() {
        Book book = bookService.queryBookById(22);
        System.out.println(book);
    }

    @Test
    public void queryBooks() {
        List<Book> books = bookService.queryBooks();
        for (Book book : books) {
            System.out.println(book);
        }
    }
}