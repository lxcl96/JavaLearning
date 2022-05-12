package chapter07_Class.Overload;

public class OverLoad {
    public static void main(String[] args) {
        //同一个类中右多个同名函数 但是入参 不一样 这样就叫做方法重载overLoad
        //好处：减轻了起名子的麻烦，减轻了记名字的麻烦
        System.out.println(100);
        System.out.println("hello， world");
        System.out.println('c');
        System.out.println(20.2);
        /*
        void println()
          通过写入行分隔符字符串终止当前行。
        void println(boolean x)
              打印 boolean 值，然后终止行。
        void println(char x)
              打印字符，然后终止该行。
        void println(char[] x)
              打印字符数组，然后终止该行。
        void println(double x)
              打印 double，然后终止该行。
        void println(float x)
              打印 float，然后终止该行。
        void println(int x)
              打印整数，然后终止该行。
        void println(long x)
              打印 long，然后终止该行。
        void println(Object x)
              打印 Object，然后终止该行。
        void println(String x)
              打印 String，然后终止该行。


         */
        int a = 111;
        int arr[] = {1, 2, 3, 4, 5};
        print(a);
        print(arr);

    }

public static void print(int n) {
    System.out.println(n + "这是整数");
}

public static void print(int arr[]) {
    for (int n: arr)
        System.out.print(n + " ");
    System.out.println("这是数组");
}
}
