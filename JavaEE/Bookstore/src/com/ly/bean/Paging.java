package com.ly.bean;

import java.util.List;

/**
 * @Author : Ly
 * @Date : 2022/5/6
 * @Description : 分页模型
 * @param <T> 分页类型，并不限制，其他类型也可以使用此模型【老师做法，实际并未采用】
 */
public class Paging<T> {

    public static final Integer page_size = 4;

    //当前页码
    private Integer pageNo;
    //总页码
    private Integer pageTotal;
    //当前页显示的数量 默认为4
    private Integer pageSize = page_size;
    //总记录数
    private Integer pageTotalCount;
    //当前页数据
    private List<T> items;

    public Paging() {
    }

    public Paging(Integer pageNo, Integer pageTotal, Integer pageSize, Integer pageTotalCount, List<T> items) {
        this.pageNo = pageNo;
        this.pageTotal = pageTotal;
        this.pageSize = pageSize;
        this.pageTotalCount = pageTotalCount;
        this.items = items;
    }

    public static Integer getPage_size() {
        return page_size;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageTotalCount() {
        return pageTotalCount;
    }

    public void setPageTotalCount(Integer pageTotalCount) {
        this.pageTotalCount = pageTotalCount;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}
