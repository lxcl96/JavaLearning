package chapter08_intermediate.Homework06;

public class Answer {
    public static void main(String[] args) {

    }
}
/*
    同一个包
grand
	super：name,age,g1() //多了一个private age
	this:name,g1(),id,score,f1()


Son
	super：name,g1(),id,score,f1() //多了一个private score
	this:id,f1(),name,g1()show()

总结：
    把super看出父类自身了，不对的 不是自身 因此 super访问不到private属性，如果不同包 super连默认的都访问不到

    就正常的权限 不要把super 看成 父类自身就ok了

 */