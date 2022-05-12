package chapter08_intermediate;

public class HomeWork03 {
    public static void main(String[] args) {
        Teacher t1 = new lecturer("韩美美", 35, "teacher",3000);
        System.out.println(t1);

    }
}
class Teacher {
    private String name;
    private int age;
    private String post;
    private double salary;

    public Teacher(String name, int age, String post, double salary) {
        this.name = name;
        this.age = age;
        this.post = post;
        this.salary = salary;
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

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", post='" + post + '\'' +
                ", salary=" + salary +
                '}';
    }
}

class Professor extends Teacher {
    @Override
    public void setSalary(double salary) {
        super.setSalary(salary * 1.3);
    }

    public Professor(String name, int age, String post, double salary) {
        super(name, age, post, salary * 1.3);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

class AsProfessor extends Teacher{
    @Override
    public void setSalary(double salary) {
        super.setSalary(salary * 1.2);
    }

    public AsProfessor(String name, int age, String post, double salary) {
        super(name, age, post, salary * 1.2);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

class lecturer extends Teacher {
    @Override
    public void setSalary(double salary) {
        super.setSalary(salary * 1.1);
    }

    public lecturer(String name, int age, String post, double salary) {
        super(name, age, post, salary * 1.1);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}