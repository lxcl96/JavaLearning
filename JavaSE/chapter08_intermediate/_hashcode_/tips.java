package chapter08_intermediate._hashcode_;

public class tips {
    public static void main(String[] args) {

    }
}
/*

    hashcode()方法： HashCode_.java
        1、提高具有哈希结构的容器的效率
        2、两个引用，如果指向的是同一个对象，则hash值肯定是一样的
        3、两个引用，如果指向的不是同一个对象，则hash值是不一样的（有特殊情况）
        4、返回的哈希值整数是根据内存地址来的，但是他俩不相同
        5、在后面的集合中，hashcode()如果需要也会被重写
 */