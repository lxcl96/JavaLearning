package chapter15_Generics_;

public class tips01 {
}
/*
    泛型的语法：
      ● 泛型的声明
       interface 接口名 <T>  【一个泛型】
       class 类名 <K,V>   【两个泛型】
       。。。
       说明：
         1、其中T，K，V就是形参 参数 没意义
         2、任意字母都可以 常用T 表示Type类型

       举例子：
         List<String> strList = new ArrayList<String>();
         Iterator<Customer> = iterator = customers.ierator()//使用指定类型的迭代器
      ●
 */