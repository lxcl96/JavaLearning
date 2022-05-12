package chapter14_Collect_.HomeWork;

import org.jetbrains.annotations.NotNull;

import java.util.TreeSet;

public class hw05 {
    public static void main(String[] args) {
        TreeSet treeSet = new TreeSet();
        treeSet.add(new Person());

        /*
            会不会报错？
            我认为这个取决于Person有没有实现Comparable的compareTo函数，如果有就不会；否则就会
         */
    }
}

class Person implements Comparable{
    @Override
    public int compareTo(@NotNull Object o) {
        return 0;
    }
}
