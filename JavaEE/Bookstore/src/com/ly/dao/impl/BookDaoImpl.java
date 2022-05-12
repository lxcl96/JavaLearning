package com.ly.dao.impl;

import com.ly.bean.Book;
import com.ly.dao.BookDao;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;

/**
 * @Author : Ly
 * @Date : 2022/5/3
 * @Description : Book类接口实现类
 */
public class BookDaoImpl extends BaseDao<Book> implements BookDao {
    @Override
    public List<Book> queryByPrice(BigDecimal lowPrice,BigDecimal highPrice,int currentPage, int number) {
        String sql = "select * from t_book where `status`=0 and price between ? and ? limit ?,?;";
        return selectMany(sql,Book.class,lowPrice,highPrice,currentPage,number);
    }

    @Override
    public int addBook(Book book) {
        String sql = "insert into t_book(bookname,price,author,sales,stock,img_path) values (?,?,?,?,?,?);";
        return update(sql,book.getBookName(),book.getPrice(),book.getAuthor(),book.getSales(),book.getStock(),book.getImg_path());
    }

    @Override
    public int delBook(Integer id) {
        String sql = "update t_book set `status` = 1 where id = ?;";
        return update(sql,id);
    }

    @Override
    public int update(Book book) {
        String sql = "update t_book set bookname=?,price=?,author=?,sales=?,stock=?,img_path=? where `status` = 0 and id = ? ;";
        return update(sql,book.getBookName(),book.getPrice(),book.getAuthor(),book.getSales(),book.getStock(),book.getImg_path(),book.getId());
    }

    @Override
    public Book queryById(Integer id) {
        String sql = "select * from t_book where id=? and `status`=0";
        return selectSingle(sql,Book.class,id);
    }

    @Override
    public List<Book> queryBooks() {
        String sql = "select * from t_book where `status`=0";
        return selectMany(sql,Book.class);
    }

    @Override
    public List<Book> queryPage(int currentPage, int number) {
        String sql = "select * from t_book where `status`=0 limit ?,?";
        return selectMany(sql,Book.class,currentPage,number);
    }

    @Override
    public int queryPages() {
        String sql = "select count(1) from t_book where `status`=0";
        return ((Long)selectScalar(sql)).intValue();
    }

    @Override
    public int queryPagesByPrice(BigDecimal lowPrice, BigDecimal highPrice) {
        String sql = "select count(1) from t_book where `status`=0 and price between ? and ?;";
        return ((Long)selectScalar(sql,lowPrice,highPrice)).intValue();
    }


}
