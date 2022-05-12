package com.ly.pojo;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Ly
 * @Date : 2022/4/24
 * @Description :
 */
public class dom4jTest {
    //dom4j 测试
    @Test
    public void test1() throws DocumentException {
        //创建 SAXReader 输入流，去读取xml配置文件 生成document对象
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read("src/books.xml");
        //System.out.println(document);
    }

    @Test
    public void test2() {
        //目标：读取books.xml文件生成book类
        ArrayList<book> booksList = new ArrayList<>();

        //1、获取SAX输入流
        SAXReader saxReader = new SAXReader();
        try {
            //2、读取xml文件，生成document对象
            Document document = saxReader.read("src/books.xml");
            //3、通过根元素获取book标签对象
            Element rootElement = document.getRootElement();
            //System.out.println(rootElement);

            //4、通过根遍历，处理每个book标签转化成book类
            //element 和elements都是通过标签名查找子元素
            //Element book = rootElement.element("book");//只查找一个
            List<Element> books = rootElement.elements("book");//查找多个
            for (Element book : books) {
                //asxml()可以把标签对象 转化为标签字符串
                //System.out.println(book.asXML());
                Element name = book.element("name");
                String nameText = name.getText();

                Element price = book.element("price");
                String priceText = price.getText();

                //直接得到指定标签的内容
                String authorText = book.elementText("author");

                //获取属性
                String snValue = book.attributeValue("sn");

                //System.out.println(nameText + priceText + authorText);
                book bookObj = new book(snValue, nameText, new BigDecimal(priceText), authorText);
                System.out.println(bookObj);
                booksList.add(bookObj);
            }

        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
