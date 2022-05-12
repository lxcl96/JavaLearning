package chapter23_reflection_.introduce;

import org.junit.Test;

/**
 * @Author : Ly
 * @Date : 2022/4/14
 * @Description :
 */
public class Cat {
    private String name = "mimi";
    protected int age = 3;
    String color = "red";
    public String nation = "china";


    @Test
    public void hi() {
        //System.out.println(getClass());
        //System.out.println("hi");
    }

    public Cat() {
        System.out.println("无参构造器");
    }

    public Cat(String name) {
        this.name = name;
        System.out.println("有参构造器" + name);
    }
}
