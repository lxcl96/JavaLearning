package chapter15_Generics_.Junit_;

import org.junit.Test;

public class JUnit_ {
    public static void main(String[] args) {
        //传统方法
        new JUnit_().m1();

        //Junit方法
    }

    @Test
    public void m1(){
        System.out.println("m1");
    }

    @Test
    public void m2(){
        System.out.println("m2");
    }
}
