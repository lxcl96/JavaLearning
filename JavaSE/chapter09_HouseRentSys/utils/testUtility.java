package chapter09_HouseRentSys.utils;

public class testUtility {
    public static void main(String[] args) {
        //测试类

        //这是一个静态方法，可直接通过类名调用 不用创建对象
        String s = Utility.readString(3);//读取长度<=3的字符串
    }
}
