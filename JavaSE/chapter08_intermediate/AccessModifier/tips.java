package chapter08_intermediate.AccessModifier;

public class tips {
    public static void main(String[] args) {

    }
}
/*
    java有四种访问修饰符，用于控制方法和属性（成员变量）的访问权限（范围）
    1、公开级别：public 对外公开                  （就是其它包也能用这个包这个方法和属性）
    2、保护级别：protected 对子类和同一包中的类公开   （只有子类和这个包能用这个方法和属性）
    3、默认级别：没有关建字 对同一包的类公开           （只有这个包能用这个方法和属性）
    4、私有级别：private 只有类本身（内部 就是这个java文件）可以访问，不对外公开
                                （只有这个类本身可以，这个包的别的类都没办法访问）


     访问级别       访问控制修饰符     同类      同包      子类      不同包
     公开           public          √         √        √        √
     受保护         protected       √         √        √        ×
     默认          无修饰符          √         √        ×        ×
     私有         private          √         ×        ×        ×


     修饰 类只有 默认和public 两种 权限同上
      访问级别       访问控制修饰符     同类      同包      子类      不同包
     公开           public          √         √        √        √
     默认          无修饰符          √         √        ×        ×
  */