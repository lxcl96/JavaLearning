package chapter10_OOPPlus;

public class HomeWork05 {
    public static void main(String[] args) {
        A a = new A();
        a.f1();
    }
}

class A {
    private String name = "jack";

    public void f1() {
        class B {
            private final String name = "tom";

            public void show() {
                System.out.println("B name=" + name);

                System.out.println("A name=" + A.this.name);
            }
        }

        new B().show();
    }
}