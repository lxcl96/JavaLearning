package chapter08_intermediate.encapsulation;

public class Encapsulation01 {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("222jack");
        person.setAge(0);
        person.setSalary(30000);

        System.out.println(person.info());


    }
}

//person类 不能随便看年龄工资隐私 对年龄进行合理化验证，不合理的给一个默认值 1-120 name长度在2-6字符
class Person {
    public String name;
    private double salary;
    private int age;

    public void setName(String name) {
        if (name.length() >= 2 && name.length() <= 6)
            this.name = name;
        else
            {
                System.out.println("name名字不符合要求（2-6字符），请重新输入。");
            }
    }
    //alt + inset 快速生成getter和setter
    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 1 && age <= 120)
            this.age = age;
        else {
            System.out.println("年龄不在规定内(1-120)，默认20");
            this.age = 20;
        }
    }

    //输出信息
    public String info() {
        return ("name=" + this.name + " age=" + this.age + " salary=" + this.salary);
    }



}