package chapter10_OOPPlus.interface_.compare_;

public class ExtendsVsInterface {
    public static void main(String[] args) {
        LitteMonkey wukong = new LitteMonkey("悟空");
        //继承的方法 天生就会爬树，但是后天学习游泳 使用接口
        wukong.climbing();

        //通过接口 后天学习得来
        wukong.swimming();
    }
}

class Monkey {
    private String name;

    public Monkey(String name) {
        this.name = name;
    }

    public void climbing() {
        System.out.println(name + "天生会爬树。。");
    }

    public String getName() {
        return name;
    }
}
//接口  类似于学习技能
interface Fishable {
    void swimming();//老师教授游泳方法，但是需要猴子自己学习
}

//继承
class LitteMonkey extends Monkey implements Fishable{
    public LitteMonkey(String name) {
        super(name);
    }
    //使用接口 类似于猴子练习学会了游泳
    @Override
    public void swimming() {
        System.out.println(getName() + "学会了游泳。。");
    }
}