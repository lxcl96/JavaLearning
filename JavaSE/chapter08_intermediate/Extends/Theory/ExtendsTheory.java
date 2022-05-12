package chapter08_intermediate.Extends.Theory;


/*
 * 讲解继承的本质
 */
public class ExtendsTheory {
    public static void main(String[] args) {
        Son son = new Son();

        //访问属性 就近原则 如果子类有且可以访问 就访问子类的该属性，如果子类没有或无法访问就去找父类，一层一层找
        // 不可以访问就报错了，但是内存中还是会开辟这个private（如）变量空间
        System.out.println(son.name);
        System.out.println(son.age);
        System.out.println(son.hobby);

        //如果想获取 GrandPa 的name就只能 建立一个方法getName或 新建3、开辟主函数main栈对象
        //Father的name同上

    }
}
/*
 *  1、加载类信息 Object->GrandPa->Father->Son
 *  2、开辟空间 0x11（GrandPa->Father->Son） （name不会冲突，因为每个类都会单独开辟空间）
 *  3、开辟主函数main栈 son 指向空间 0x11
 */
class GrandPa {
    String name = "大头爷爷";
    String hobby = "旅游";
    //儿子age是私有，爷爷age是公有也不行 会报错  因为是从son->Father->GrandPa的顺序 在Father找到了只是没权限访问而已
    int age = 88;
}

class Father extends GrandPa {
    String name = "大头爸爸";
    int age = 39;
}

class Son extends Father {
    String name = "大头儿子";
}