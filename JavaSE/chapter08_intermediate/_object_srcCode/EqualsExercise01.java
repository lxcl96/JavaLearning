package chapter08_intermediate._object_srcCode;

public class EqualsExercise01 {
    //多态的使用 传递父类类型
    public static boolean equals(Object p1, Object p2) {
        if (p1 == p2) //如果怕p1 p2地址相同 直接返回
            return true;
        //如果俩地址不一样，比较运行类型 如果都为Person继续比较属性
        if (p1 instanceof Person && p2 instanceof Person) {
            if (((Person) p1).getName() == ((Person) p2).getName() && ((Person) p1).getAge()
            == ((Person) p2).getAge() && ((Person) p1).getGender() == ((Person) p2).getGender())
                return true;
        }
        return false;
    }


    public static void main(String[] args) {
        Person p1 = new Person("小明", 22, '男');
        Person p2 = new Person("小红", 22, '女');
        Person p3 = new Person("小红", 22, '女');
//        System.out.println(equals(p1, p1));//和自身比较 true
//        System.out.println(equals(p1, p2));//和非自身 不同比较 false
//        System.out.println(equals(p2, p3));//和非自身 相同比较 true
        System.out.println(p1.equals(p1));
        System.out.println(p1.equals(p2));
        System.out.println(p2.equals(p3));

    }
}
//重写equals方法：判断两个Person对象的内容是否相同，如果两个Person对象的各个属性值都一样，则返回true反之false
class Person {
    private String name;
    private int age;
    private char gender;

    public Person(String name, int age, char gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
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

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    //一个参数重写 *****必须要放在 目标类中 不然 你根本获取不到this属性
    public boolean equals(Object p1) {
        if (p1 == this) //如果怕p1 p2地址相同 直接返回
            return true;
        //如果俩地址不一样，比较运行类型 如果为Person继续比较属性
        if (p1 instanceof Person) {
            Person newPerson = (Person)p1;
            //如何获取本类 this信息  这个太罗嗦 试试这个
//            if (newPerson.getName().equals(this.getName())) 只要Object的属性能用equals
            if (newPerson.getName() == this.getName() && newPerson.getAge() == this.getAge() && newPerson.getGender() == this.getGender())
                return true;
        }
        return false;
    }
}