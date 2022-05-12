package chapter_19_IO_.Properties_;

/**
 * @Author : Ly
 * @Date : 2022/4/2
 * @Description :Propeties类的基本介绍
 */
public class tips {

}

/*
    Properties:是HashTable得分子类
    1、是专门用于读写配置文件的集合类
      配置文件的格式：
      键=值
    2、注意键值对不需要有空格，值不需要用引号引起来，默认是String

    3、Properties的常见方法
        load：加载配置文件的键值对到Properties对象
        list：将数据显示到指定设备
        getProperty(key)：根据建取值
        setProperty(key,value)：设置键值对到Property对象
        store:将Property中的键值对存储到配置文件中，在idea中，保存信息到配置文件，如果含有中文，会存储为unicode编码
 */