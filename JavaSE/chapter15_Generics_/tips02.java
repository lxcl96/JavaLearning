package chapter15_Generics_;

public class tips02 {
    public static void main(String[] args) {
        String s = "20111111";
    }
}
/*
    泛型的使用细节：
    1、泛型可以用于接口或者类 【且泛型个数不限，但是需要注意 传入的数据类型必须为引用数据类型】
     ArrayList<Integer> list = new ArrayList<Integer>(); 对的
     ArrayList<int> list = new ArrayList<int>(); 错的，传入基本数据类型
     【窍门： 父类为Object】

    2、在指定泛型基本类型后可以传入，该类型或者其子类型
      ArrayList<Object> list = new ArrayList<Object>(); 对Object包括其子类都可以

    3、泛型的使用形式【两种】
     形式1、
      ArrayList<Integer> list = new ArrayList<Integer>();  对的
      List<Integer> list = new ArrayList<Integer>(); 对的

     形式2、
      ArrayList<Integer> list = new ArrayList<>();  对的
      List<Integer> list = new ArrayList<>(); 对的

      【注意：】
       ArrayList list = new ArrayList() //没用泛型符号
        等价于
       ArrayList<Object> list = new ArrayList<Object>()
        等价于
       ArrayList<Object> list = new ArrayList<>()
 */