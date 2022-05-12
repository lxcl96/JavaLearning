package chapter08_intermediate.HomeWork11;
//视频 p352
public class HomeWork11 {
    public static void main(String[] args) {
        //向上转型 看编译类型 被重写了的才看运行类型
        Person person = new Student();
        person.run();
        person.eat();

        /*
            person可以访问：
                run() student run 动态绑定
                study()  x 向上 转型 访问不了特有的方法和属性
                eat()
         */


        //向下转型： 就相当于正常声明了 权限允许的都能访问到
        Student st = (Student)person;
        st.run();
        st.study();
        st.eat();
         /*
            st可以访问：
                run() student run
                study() student study
                eat()
         */
    }
}
