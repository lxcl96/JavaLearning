package chapter08_intermediate.HomeWork13;

public class Teacher extends Person{
    private int work_age;

    public Teacher(String name, char sex, int age, int work_age) {
        super(name, sex, age);
        this.work_age = work_age;
    }

    public int getWork_age() {
        return work_age;
    }

    public void setWork_age(int work_age) {
        this.work_age = work_age;
    }

    public String teach() {
        return "我承诺，我会认真教书。";
    }

    @Override
    public String play() {
        return super.play() + "象棋";
    }

    public String print() {
        return "老师的信息：\n姓名：" + this.getName()
                + "\n年龄：" + this.getAge()
                + "\n性别：" + this.getSex()
                + "\n工龄：" + this.getWork_age()
                + "\n" + this.teach()
                + "\n" + this.play();
    }
}
