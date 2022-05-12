package chapter08_intermediate.Polymorphism;

public class PolyExercise01 {
    public static void main(String[] args) {
        int i = 5;
        //java中不能直接把 数字 转变为字符
       // String j = (String)i;
    }
}
/*
   我的答案     实际答案
   √              ok           double d = 13.4
   √              ok           long l = (long)d
   √              13           sout(l)

   √              ok           int in =5
   x              x            boolean b = (boolean)in

   √              ok           Object obj = "Hello" 向上转型
   √              ok           String objStr = (String)obj; 向下转型
   √              hello        sout(objStr)

   √              ok          Object objPri = new Integer(5) 向上转型
   x              x           String str = (String)objPri  想把指向运行类型为Integer变成String 不对
   √              ok          Integer str1 = (Integer)objpri 向下转型
 */