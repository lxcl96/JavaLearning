package chapter23_reflection_.introduce;

import org.junit.Test;

/**
 * @Author : Ly
 * @Date : 2022/4/15
 * @Description :
 */
public class Car {
    public String brand = "宝马";
    public int price = 500000;
    public String color = "黑";

    @Test
    public void f1() {
        System.out.println(this.getClass());
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                '}';
    }
}
