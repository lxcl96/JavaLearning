package chapter08_intermediate;

public class HomeWork01 {
    public static void main(String[] args) {
        //Person数组数量
        int num = 3;
        Person[] p = new Person[num];
        p[0] =  new Person("李雷", 20, "学生");
        p[1] = new Person("韩梅梅", 20, "学生");
        p[2] = new Person("王老师", 40, "老师");
        BubbleSort bubbleSort = new BubbleSort();
        System.out.println("初始顺序：");
        bubbleSort.print(p);
        bubbleSort.BubbleSort(p);
        System.out.println("p冒泡排序后顺序：");
        bubbleSort.print(p);

    }
}
/*
    定义一个Person类{name，age，job}，初始化Person对象数组，有3个Person对象，并按照age从大到小进行排序，使用冒泡

 */
class Person {
    private String name;
    private int age;
    private String job;

    public Person(String name, int age, String job) {
        this.name = name;
        this.age = age;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }


}

class BubbleSort {
    //输出信息
    public void print(Person[] personArr) {
        for (int i = 0; i < personArr.length; i++) {
            System.out.println("姓名：" + personArr[i].getName() + "，年龄：" + personArr[i].getAge() + "，职业：" + personArr[i].getJob());
        }
    }
    //对对象 按照年龄排序 从大到小
    public void BubbleSort(Person[] personArr) {
        Person tmp = null;
        for (int i = 0; i < personArr.length - 1; i++) {
            for (int j = 0; j < personArr.length - 1 - i; j++) {
                if (personArr[j].getAge() < personArr[j + 1].getAge()) {
                    tmp = personArr[j];
                    personArr[j] = personArr[j + 1];
                    personArr[j + 1] = tmp;
                }
            }
        }
    }
}
