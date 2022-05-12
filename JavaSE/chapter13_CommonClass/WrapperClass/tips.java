package chapter13_CommonClass.WrapperClass;

public class tips {

}
/*
    包装类的分类：
      1、对八种基本的数据类型 的相应的引用方法 就是包装类
      2、有了类的特点，就可以调用类的方法

      基本数据类型                包装类
      boolean                   Boolean             【Object的子类】
      char                      Character           【Object的子类】
      byte                      Byte   【NUMBER的子类】
      short                     Short   【NUMBER的子类】
      int                       Integer 【NUMBER的子类】
      long                      Long    【NUMBER的子类】
      float                     Float   【NUMBER的子类】
      double                    Double  【NUMBER的子类】

    包装类和基本数据类的转换  【Integer01。java】
    演示 包装类 和基本数据类型的相互转换，这里以int和Integer为例
        jdk1.5之前的手动装箱和 手动拆箱方式，【装箱：基本类型--》包装类型】 【拆箱：包装类型--》基本类型】
        jdk1.5（含）后为自动装箱和拆箱
        【自动装箱底层调用的是valueOf()方法如Integer。valueOf()】
 */
