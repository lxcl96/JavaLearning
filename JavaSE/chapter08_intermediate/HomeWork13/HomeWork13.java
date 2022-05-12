package chapter08_intermediate.HomeWork13;

public class HomeWork13 {
    public static void bubbleSort(Person[] p) {
        Person tmp = null;
        for (int i = 0; i < p.length - 1; i++) {
            for (int j = 0; j < p.length - 1 - i; j++) {
                if (p[j].getAge() < p[j + 1].getAge()) {
                    tmp = p[j];
                    p[j] = p[j + 1];
                    p[j + 1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Person[] p = new Person[4];
        p[0] = new Student("小明", '男', 12, "202201170949");
        p[1] = new Student("小红", '女', 11, "202201170950");
        p[2] = new Teacher("王老师", '男', 42, 20);
        p[3] = new Teacher("刘老师", '女', 35, 10);

//        for (int i = 0; i < p.length; i++) {
//            System.out.println(p[i]);
//        }
//
//        bubbleSort(p);
//        System.out.println("年龄从高到低排序后：");
//        for (int i = 0; i < p.length; i++) {
//            System.out.println(p[i]);
//        }
//        System.out.println("---------------------------------");
//        for (int i = 0; i < p.length; i++) {
//            System.out.println(p[i].play());
//        }

        System.out.println("===================完整输出==============");
        for (int i = 0; i <p.length; i++) {
            if (p[i] instanceof Student) {
                System.out.println(((Student)p[i]).print());;
            }
            if (p[i] instanceof Teacher) {
                System.out.println(((Teacher)p[i]).print());;
            }
            System.out.println("-----------------------------");
        }
    }
}
