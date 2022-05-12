package chapter14_Collect_.Map_.HashMap_;

import java.util.HashMap;

//模拟HashMap触发扩容、树化情况并debug验证
public class HashMapSource02 {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        for (int i = 1; i <= 12; i++) {
            hashMap.put(new A(i), "hello");
        }
    }
}


class A {
    private int num;

    public A(int num) {
        this.num = num;
    }
    //固定返回 相同的hash值 放在同一个链表上
    @Override
    public int hashCode() {
        return 100;
    }
}
