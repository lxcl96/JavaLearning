package chapter12_Exception.ExceptionDIY;



//当我们接收Person对象年龄时，要求范围在18 - 120之间，否则抛出一个自定义异常（要求继承RunTimeException），并给出提示信息
public class CustomException {
    public static void main(String[] args) {
        new Person(10);
    }
}

class Person {
    private int age;
    AgeRangeException s = new AgeRangeException("年龄错误");
    public Person(int age) {
        if (age < 18 || age > 120)
            throw s;
        this.age = age;

    }

    public int getAge() throws NullPointerException{
        return age;
    }
}

class AgeRangeException extends RuntimeException {
    public AgeRangeException() {
    }

    public AgeRangeException(String message) {
//        System.out.println(message);
        super(message);
    }
}