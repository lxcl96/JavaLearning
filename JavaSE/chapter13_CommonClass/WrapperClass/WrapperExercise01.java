package chapter13_CommonClass.WrapperClass;

public class WrapperExercise01 {
    public static void main(String[] args) {

        //自动装箱,实际就是 Double d = Double.valueOf(100d)
        Double d = 100d;//d代表double类型,不写表示为int

        //自动装箱,实际就是 Float f = Float.valueOf(1.5f)
        Float f = 1.5f;//f代表float,不加就是double

        //问:下面obj1和obj2的输出结果是否相同?各是什么
        Object obj1 = true?new Integer(1):new Double(2.0);
        System.out.println(obj1);
        Object obj2;
        if (true)
            obj2 = new Integer(1);
        else
            obj2 = new Double(2.0);
        System.out.println(obj2);

        /*
            答:
                obj1的结果是:1.0
                    【因为三言运算符看成是一个整体】,int 和double两个类型取其大 double,类型自动转换了

                obj2的结果是:1

         */

    }
}
