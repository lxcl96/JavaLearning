package chapter07_Class;

public class HomeWork13 {
    public static void main(String[] args) {
        Circle c = new Circle();
        PassObject p = new PassObject();
        p.printAreas(c, 5);
    }
}

class Circle {
    double radius;
    public double findArea(double radius) {
        //返回圆 面积
        return Math.PI * radius * radius;
    }
}

class PassObject {
    public void printAreas(Circle c, double times) {
        //打印1到times 整数及圆面积
        System.out.println("Radius          Area");
        if (times <= 0) {
            System.out.println("非法半径 " + times);
            return;//结束了
        }
        for (double n = 1; n <= times; n++) {
            System.out.println(n + "             " + c.findArea(n));
        }
    }
}