package chapter10_OOPPlus.codeBlock;

public class
codeBlock01 {
    public static void main(String[] args) {
        //隐式调用，加载类时【或类初始化，一样的】自动调用代码块
        Movie m = new Movie();

        //显示调用 调用不到代码块
        System.out.println("==============调用f1 方法");
        m.f1();
        System.out.println("==============调用f2 方法");
        m.f2();
    }
}
class Movie {
    {
        System.out.println("广告即将结束，电影马上开始！");
        System.out.println("即将播放的影片为：霸王别姬");
    }

    public void f1() {
        System.out.println("f1() 方法");
    }

    public void f2() {
        System.out.println("f2() 方法");
    }
}