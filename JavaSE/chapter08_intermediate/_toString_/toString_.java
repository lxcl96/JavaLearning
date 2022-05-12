package chapter08_intermediate._toString_;

public class toString_ {
    public static void main(String[] args) {
        Monster monster = new Monster("小钻风", "抓唐僧");
        //全类名
        System.out.println("全类名 = " + monster.getClass().getName());
        System.out.println("monster的hashCode()=" + monster.hashCode() + " 16进制为：" + Integer.toHexString(monster.hashCode()));
        //全类名+@+哈希值的十六进制
        System.out.println("toString()=" + monster.toString());
        //System.out.println(monster)默认调用toString()方法 结果和 monster.toString()一样
        System.out.println(monster.toString());
        System.out.println(monster);
    }
}

/*
    public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
    }
 */


class Monster {
    private String name;
    private String job;

    public Monster(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    //重写toString()方法，输出对象属性 alt + insert 选择toString


    public String toString1() {
        return "Monster{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                '}';
    }
}