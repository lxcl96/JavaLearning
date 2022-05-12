package chapter14_Collect_.Set_.HashSet_;

import java.util.HashSet;

public class HashSetIncrement {
    public static void main(String[] args) {
        //讲解HashSet扩容原则  第一次添加就是16 后面扩容就是 newCap = oldCap << 1 增长一倍 【算术左移*2的1方】
        // 16[阈值：16*0.75=12]  =>  32[阈值：32*0.75=24]  =>64 [阈值：64*0.75=48]
        HashSet hashSet = new HashSet();

//        for (int i = 1; i <= 100; i++) {
//            hashSet.add(i); //threshold代表阈值
//        }

        //红黑树化
        /**
         *      1-8无意外，正常加入 都挂在同一个链表下【此时table表长度为16】
         *     到第9时因为链表长度已经到达8，想进行红黑树化结果发现table表没有达到64长度，16进行扩容【此时table表长度为32】
         *     到第10时因为链表长度已经到达8，想进行红黑树化结果发现table表没有达到64长度，32进行扩容【此时table表长度为64】
         *     到第11时，链表长度为8而且table表长度也为64了进行红黑树化，【有parent，pre, next, left,right】
         */
//        for (int i = 1; i <= 12; i++) {
//            hashSet.add(new A(i));
//        }


        /**
         * 说明：
         *  不管结点是放在链表中，还是table数组中的，只要同一个链表没有达到8个
         *      总个数【链表结点+table数组已占用的】达到 阈值12 第13次都会扩容
         */
        for (int i = 1; i <= 7; i++) {
            hashSet.add(new A(i));
        }
        for (int i = 1; i <= 6; i++) {
            hashSet.add(new B(i));
        }


    }
}

//通过重写hashCode()保证每次都是返回一样的值
class A {
    private int n;

    public A(int n) {
        this.n = n;
    }

    @Override
    public int hashCode() {
        return 100;
    }
}

class B {
    private int n;

    public B(int n) {
        this.n = n;
    }
    @Override
    public int hashCode() {
        return 200;
    }
}