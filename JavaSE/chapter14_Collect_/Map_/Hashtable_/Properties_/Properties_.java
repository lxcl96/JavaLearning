package chapter14_Collect_.Map_.Hashtable_.Properties_;

import java.util.Properties;

public class Properties_ {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put("john", 100);//来自父类Hashtable的方法 k-v均不能为null
        properties.put("lucy", 100);//
        properties.put("lic", 100);//
        properties.put("lic", 80);//替换

        //通过key取值【查】
        System.out.println(properties.get("lic")); //父类的方法
        System.out.println(properties.getProperty("lic"));

        //删除 remove
        System.out.println(properties.remove("lic"));

        //修改 就是put 把key设为一样就可以了

        System.out.println(properties);
    }
}
