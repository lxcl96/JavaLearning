package chapter08_intermediate.Polymorphism._polapplication_._polyArray_;

public class PolyArray {
    public static void main(String[] args) {
        Person[] person = new Person[5];
        person[0] = new Person("李华", 32);
        person[1] = new Student("小明", 15, 80);
        person[2] = new Student("小红", 14, 90);
        person[3] = new Teacher("李雷", 30, 8000);
        person[4] = new Teacher("韩梅梅", 28, 8500);
//        System.out.println(person[0].say());//李华22
//        System.out.println(person[1].say());//小明1580
//        System.out.println(person[2].say());
//        System.out.println(person[3].say());
//        System.out.println(person[4].say());
        for (int i = 0; i < person.length; i++) {
            System.out.println(person[i].say());
            //调用特有方法 不能直接调用 因为编译类型 是Person  需要向下转换
            //person[i].study();
            if (person[i] instanceof Student)//通过判断 运行类型 来比下标更专业
                ((Student)person[i]).study();
            if (i == 3 || i == 4)
                ((Teacher)person[i]).teach();
        }




    }
}
