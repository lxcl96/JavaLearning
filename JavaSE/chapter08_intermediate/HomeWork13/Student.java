package chapter08_intermediate.HomeWork13;

public class Student extends Person{
    private String stu_id;

    public Student(String name, char sex, int age, String stu_id) {
        super(name, sex, age);
        this.stu_id = stu_id;
    }

    public String study() {
        return "我承诺，我会好好学习。";
    }

    public String getStu_id() {
        return stu_id;
    }

    public void setStu_id(String stu_id) {
        this.stu_id = stu_id;
    }

    @Override
    public String play() {
        return super.play() + "足球";
    }

    public String print() {
        return "学生的信息：\n姓名：" + this.getName()
                + "\n年龄：" + this.getAge()
                + "\n性别：" + this.getSex()
                + "\n学号：" + this.getStu_id()
                + "\n" + this.study()
                + "\n" + this.play();
    }
}
