package chapter15_Generics_.InheritAndWildcard_;

public class tips {
}
/*
    泛型的继承[inherit]和通配符[Wildcard]：
      1、泛型不具备继承性
        List<Object> list = new ArrayList<String>(); 这个是错误的【前后必须一致，或者后面为空】
      2、<?> 表示任意泛型类型

      3、<? extends A> 支持A类以及A的子类，不限于直接子类【孙子】，规定了泛型的上限

      4、<? super A> 支持A类以及A的父类，不限于直接父类【爷爷】，规定了泛型的下限
 */