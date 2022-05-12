package com.ly.json;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.ly.pojo.HashMapType;
import com.ly.pojo.Person;
import com.ly.pojo.PersonListType;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Author : Ly
 * @Date : 2022/5/11
 * @Description :
 */
public class JsonTest {

    //1、JavaBean和json的相互转化
    @Test
    public void test1() {
        Person person = new Person(1,"hsp");
        Gson gson = new Gson();
        //JavaBean转化为json字符串
        String personJsonStr = gson.toJson(person);
        System.out.println(personJsonStr);

        //json字符串转化为JavaBean ，第二参数为class是转化成一个对象使用的，如果是集合多个对象 需要使用type参数
        Person personBean = gson.fromJson(personJsonStr, person.getClass());
        System.out.println(personBean);
    }

    //2、List和Json的相互转化
    @Test
    public void test2() {
        ArrayList<Person> strList = new ArrayList<>();
        strList.add(new Person(1,"hsp"));
        strList.add(new Person(2,"ly"));
        System.out.println(strList);

        Gson gson = new Gson();
        String strListJsonStr = gson.toJson(strList);
        System.out.println(strListJsonStr);
        //json字符串转化为List集合 使用person.getClass()无法转化为Person类型
        //需要用到 gson中的反射类 TypeToken
        /*
            做法如下：
            1、新建一个类 继承gson中的TypeToken类如PersonListType 并指定该类泛型为 要转换的类型 即 ArrayList<Person>
            2、调用fromJson()方法，其中第二个参数为 new PersonListType().getType()
         */
        //ArrayList<Person> arrayList = gson.fromJson(strListJsonStr, strList.getClass());
        ArrayList<Person> arrayList = gson.fromJson(strListJsonStr, new PersonListType().getType());
        Person person = arrayList.get(0);
        System.out.println(arrayList);
    }

    //3、Map和Json的相互转化
    @Test
    public void test3() {
        HashMap<String, Person> hashMap = new HashMap<>();
        hashMap.put("1",new Person(1,"hsp"));
        hashMap.put("2",new Person(2,"ly"));
        System.out.println(hashMap);

        Gson gson = new Gson();
        String s = gson.toJson(hashMap);
        System.out.println(s);

        //map转换成json 方法和List的一样
        //HashMap hashMap1 = gson.fromJson(s, hashMap.getClass());
        //内部类  class Type extends TypeToken<HashMap<String,Person>> {}

        //匿名内部类 new 接口()/类() {}.方法()
        HashMap hashMap1 = gson.fromJson(s, new TypeToken<HashMap<String,Person>>() {}.getType());
        System.out.println(hashMap1);

    }
    @Test
    public void test4() {

        JsonObject obj = new JsonObject();
        obj.addProperty("isAvailable",true);
        System.out.println(obj);
        System.out.println(new Gson().toJson(obj));
    }
}
