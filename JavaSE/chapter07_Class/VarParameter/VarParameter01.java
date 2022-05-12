package chapter07_Class.VarParameter;

public class VarParameter01 {
    public static void main(String[] args) {
        //可变参数
        //java允许将同一类中 多个同名 同功能 但参数不同的方法，封装成一个方法
        HspMethod example = new HspMethod();
        int [] a = {1, 2, 3, 4};
        int [] b = {4, 3, 2, 1};
//        example.sum(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//        example.print2(a);
//        example.print(a, b);
        example.showScore("hello",30, 1, 55.5, 100, 99.9);

    }
}
/*
        注意：
            1、可变参数范围为 0-n
            2、可变参数的实参 可以为数组，那么此时nums为数组+1为（1，2）（2，3）.。。
            3、可变参数的本质就是数组
            4、可变参数可以和一般参数一起用，但是必须要 放在最后
            5、一个形参列表只用使用一个可变参数
 */
class  HspMethod {
    //可以计算2个数的和 3个数 4个数。。。。
    //可以使用方法重载

    //可变参数格式：访问修饰符 返回类型 方法名(数据类型... 形参名){}
    //可变参数使用时当数组来使用
    public void sum(int... nums) { //其中nums范围0-n
        System.out.println("接收的个数：" + nums.length);
        int ret = 0;
        for (int n : nums)
            ret += n;
        System.out.println("总和为：" + ret);
    }
    public void print(int[]... nums) {
        for (int i = 0; i < nums.length; i++)
            for (int j = 0; j < nums[i].length; j++)
                System.out.print(nums[i][j] + " ");
        System.out.println();
    }
    public void print2(int... nums) {
        for (int i = 0; i < nums.length; i++)
            System.out.println(nums[i]);
    }
    public void showScore(String name, double... score) {
        System.out.println("姓名： " + name);
        double ret = 0;
        for (double n : score)
            ret += n;
        System.out.println(score.length + " 门课总分是：" + ret);
    }
}