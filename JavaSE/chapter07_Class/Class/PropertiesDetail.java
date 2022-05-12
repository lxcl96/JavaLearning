package chapter07_Class.Class;

public class PropertiesDetail {
    public static void main(String[] args) {
        //p1 为对象名称，new Person()才是一个真正的对象
            //z直接创建一个对象 Person p1 = new Person();
        //先声明再创建一个一个对象
        Person p1;
        p1 = new Person();
        //对象的属性默认值，遵循数组的规则
        System.out.println(p1.age);
        System.out.println(p1.name);
        System.out.println(p1.salary);
        System.out.println(p1.isPass);
    }
}

/*
    属性定义语法同变量  示例：访问修饰符 属性类型 属性名
    其中访问修饰符用来控制属性的 访问范围
    访问修饰符：
        public
        protected
        默认 即啥都加
        private

 */
class Person {
    int age;
    String name;
    double salary;
    boolean isPass;
}
