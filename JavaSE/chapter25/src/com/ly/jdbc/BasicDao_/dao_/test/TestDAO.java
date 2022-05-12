package com.ly.jdbc.BasicDao_.dao_.test;

import com.ly.jdbc.BasicDao_.dao_.dao.ReportDAO.GoodsDAO;
import com.ly.jdbc.BasicDao_.dao_.dao.ReportDAO.ReportDAO;
import com.ly.jdbc.BasicDao_.dao_.domain.Goods;
import com.ly.jdbc.BasicDao_.dao_.domain.Report;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;

/**
 * @Author : Ly
 * @Date : 2022/4/19
 * @Description : 测试各种DAO
 */
public class TestDAO {

    @Test
    //测试ReportDAO 对report表的操作
    public void testReportDAO() {
        GoodsDAO goodsDAO = new GoodsDAO();

        //测试一个多行查询
        List<Goods> reports = goodsDAO.queryMany("select * from goods", Goods.class);
        Iterator<Goods> iterator = reports.iterator();
        System.out.println("多行查询");
        while (iterator.hasNext()) {
            Goods next = iterator.next();
            System.out.println(next);
        }

        //测试一个单行查询
        Goods goods = goodsDAO.querySingle("select * from goods where id=?", Goods.class, 20);
        System.out.println("单行查询");
        System.out.println(goods);

        //单行单列查询
        Object o = goodsDAO.queryScalar("select goods_name from goods where id=?", 10);
        System.out.println("单行单列查询");
        System.out.println(o);

    }

    @Test
    //测试ReportDAO 对report表的操作
    public void testReportDAO_01() {
        GoodsDAO goodsDAO = new GoodsDAO();

        //dml操作
        //int update = reportDAO.update("insert into goods values (?,?,?)", 10,"华为手机", 2000);
        //int update = goodsDAO.update("insert into goods values (?,?,?)", 10,"华为手机", 2000);
        int update1 = goodsDAO.update("insert into goods values (?,?,?)", 20,"苹果收集", 3000);
        int update2 = goodsDAO.update("insert into goods values (?,?,?)", 30,"小米手机", 2000);
        int update3 = goodsDAO.update("insert into goods values (?,?,?)", 50,"三星手机", null);
        //System.out.println(update > 0 ? "dml语句操作成功":"dml语句操作失败");
        System.out.println(update1 > 0 ? "dml语句操作成功":"dml语句操作失败");
        System.out.println(update2 > 0 ? "dml语句操作成功":"dml语句操作失败");
        System.out.println(update3 > 0 ? "dml语句操作成功":"dml语句操作失败");


    }
}
