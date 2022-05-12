package chapter08_intermediate.Bao;

import chapter08_intermediate.Bao.xiaoqiang.dog;
//dog类重复 不能这样导入了
//import chapter08_intermediate.learnPackage.xiaoming.dog;

public class test {
    public static void main(String[] args) {
        dog dog = new dog();//xiaoqiang.dog;
        //绝对路径直接 导入
        chapter08_intermediate.Bao.xiaoming.dog dog1 = new chapter08_intermediate.Bao.xiaoming.dog();
        System.out.println(dog);
        System.out.println(dog1);
    }
}
