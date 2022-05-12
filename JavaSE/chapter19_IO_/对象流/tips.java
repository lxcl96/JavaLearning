package chapter_19_IO_.对象流;

/**
 * @Author : Ly
 * @Date : 2022/4/2
 * @Description :
 */
public class tips {
}
/*
    序列化和反序列化：
    1、序列化就是在保存数据时，保存数据的值和数据类型
    2、反序列化就是在恢复数据时，恢复数据的值和数据类型
    3、需要让某个对象支持序列化机制，则必须要让其类是可序列化的（实现接口Serializable），为了让某个类可序列化的，
        该类必须实现如下两个接口之一：
            Serializable：//这是一个标记接口,没有任何方法
            Externalizable：//该接口有方法需要需要实现，所以一般推荐上面的方法

 */