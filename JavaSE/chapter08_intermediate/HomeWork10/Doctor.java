package chapter08_intermediate.HomeWork10;

public class Doctor {
    private String name;
    private int age;
    private String job;
    private char gender;
    private double salary;

    public Doctor(String name, int age, String job, char gender, double salary) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.gender = gender;
        this.salary = salary;
    }

    //重写父类equals方法 判断两个对象是否相同

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Doctor doctor = (Doctor) o;
//        return age == doctor.age &&
//                gender == doctor.gender &&
//                Double.compare(doctor.salary, salary) == 0 &&
//                name.equals(doctor.name) &&
//                job.equals(doctor.job);
//    }

    public boolean equals(Object obj) {
        if (this == obj) return true;//如果俩地址一样
        //getclass()输出  class chapter08_intermediate.tes
        //判断是不是同一个类 instanceof
//        if (obj == null || getClass() != obj.getClass()) return false;//判断非空 或 是不是同一个类
        if (obj == null || !(obj instanceof Doctor)) return false;//顺序很重要  Doctor instanceof obj就会出错
        //向下转型
        Doctor doctor =(Doctor)obj;
        return age == doctor.age && name.equals(doctor.name) && job.equals(doctor.job) && gender == doctor.getGender()
                && salary == doctor.salary;

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

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
