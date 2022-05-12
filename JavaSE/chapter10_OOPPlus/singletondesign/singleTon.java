package chapter10_OOPPlus.singletondesign;

public class singleTon {
    public static void main(String[] args) {
        girlFriend.getInstance();
    }
}

class girlFriend {
    private String name;
    //2、在本类的内部创建一个对象
    private static girlFriend nv = new girlFriend("小红");
    //1、构造器私有化
    private girlFriend(String name) {
        this.name = name;
    }
    //提供一个外面的静态方法
    public static void getInstance() {
        System.out.println("我的女朋友是：" + nv.name);
    }


}