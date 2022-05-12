package chapterFormer;

public class Logicoperator {
    public static void main(String[] args) {
        int a = 4;
        int b = 9;
        if(a < 1 && ++b < 50) { // a=4 b不执行了
            System.out.println("ok100");
        }
        System.out.println("a=" + a + ", b=" + b); // a=4 b=9 不执行了

        //逻辑与 & 与 短路与 && 区别
        //逻辑与 & 不管第一个条件是否为真 都会执行后面的
        //短路与 && 只有第一个条件为true 才会执行后面的


        // 逻辑或 | 与 短路或 || 区别相同
        // 逻辑或 | 不管第一个条件是否为真 都会执行后面的
        // 短路与 || 只有第一个条件为false 才会执行后面的

        int a1 = 4;
        int b1 = 9;
        if(a1 < 1 & ++b1 < 50) { // a=4 b=10 依旧执行
            System.out.println("ok200");
        }
        System.out.println("a=" + a + ", b=" + b1); // a=4 b=10 依旧执行

    }
}
