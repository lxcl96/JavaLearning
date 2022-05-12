package chapter13_CommonClass;

public class test {
    public static void main(String[] args){
        int aaaa = 999999;
        System.out.println(("" + aaaa).length());
        String a="1",b="2";

        swap(a,b);

        System.out.println(a+b);//想输出“21”

    }
    //函数栈内交换,栈外没交换
    static void swap(String a,String b){

        String temp=a;

        a=b;

        b=temp;
        System.out.println(a+b);//想输出“21”

    }
}

