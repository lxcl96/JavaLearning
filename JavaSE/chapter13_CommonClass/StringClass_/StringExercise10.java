package chapter13_CommonClass.StringClass_;

public class StringExercise10 {
    public static void main(String[] args) {
        Test ex = new Test();
        ex.change(ex.str, ex.ch);
        System.out.println("-----------------------");
        System.out.print(ex.str + "and");
        System.out.println(ex.ch);
    }
}
/*
    我的答案:
        javaandhava
     实际答案:
        hspandhava
     错误原因:
        没有分清main栈和方法exchange栈的区别,实际只改变了exchange栈的变量没有改变main栈的
 */
class Test {
    String str = new String("hsp");
    final char[] ch = {'j', 'a', 'v', 'a'};
    public void change(String str, char ch[]) {
        str = "java";
        ch[0] = 'h';
        System.out.println("等同于");
        System.out.print(this.str + "and");
        System.out.println(this.ch);
        System.out.println("函数内输出才是这样:");
        System.out.print(str + "and");
        System.out.println(ch);

    }

}
