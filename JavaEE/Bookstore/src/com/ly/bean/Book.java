package com.ly.bean;

import java.math.BigDecimal;

/**
 * @Author : Ly
 * @Date : 2022/5/2
 * @Description : 对应数据库的t_book表
 */
public class Book {
    private Integer id;
    private String bookName;
    private BigDecimal price;
    private String author;
    private Integer sales;
    private Integer stock;
    private String img_path = "static/img/default.jpg";
    private Integer status;

    public Book() {
    }

    public Book(Integer id, String bookName, BigDecimal price, String author, Integer sales, Integer stock, String img_path) {
        this.id = id;
        this.bookName = bookName;
        this.price = price;
        this.author = author;
        this.sales = sales;
        this.stock = stock;
        if (img_path != null && !"".equals(img_path)) {
            this.img_path = img_path;
        }
        this.status = 0;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getImg_path() {
        return img_path;
    }

    public void setImg_path(String img_path) {
        if (img_path != null && !"".equals(img_path)) {
            this.img_path = img_path;
        }
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", price=" + price +
                ", author='" + author + '\'' +
                ", sales=" + sales +
                ", stock=" + stock +
                ", img_path='" + img_path + '\'' +
                '}';
    }
}
