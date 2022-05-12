package chapter15_Generics_.DIYGenerics.Class_;

public class CustomGenericsExercise {
    public static void main(String[] args) {
        Tiger<Double, String, Integer> g = new Tiger<Double, String, Integer>("john");

        g.setT(10.9);//我的答案：√  Double
        //g.setT("YY");//我的答案：x  Double
        System.out.println(g);//我的答案：john，10.9，null，0
        Tiger g2 = new Tiger("john~~");
        g2.setT("YY");//我的答案：√  Object
        System.out.println("g2=" + g2);//我的答案：john~~,YY,null,null


    }
}
