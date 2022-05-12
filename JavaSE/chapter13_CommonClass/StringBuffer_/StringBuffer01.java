package chapter13_CommonClass.StringBuffer_;
//重点 :char[] value不是final类型【真实值】存放在堆中  ,final char[] value【真实值】存放在常量池中，堆中存放的是
public class StringBuffer01 {
    public static void main(String[] args) {
        //1. StringBuffer 的直接父类是AbstractStringBuilder
        //2. StringBuffer实现了Serializable即StringBuffer可以串行化
        //3. StringBuffer 的直接父类是AbstractStringBuilder有属性char[] value不是final类型,
        //    该value数字存放字符串内容,引出存放在堆中
        //4. StringBuffer是一个final类,不能被继承
        //5. 因为StringBuffer字符序列是存放在char[] value 而不是 final char[] value，【StringBuffer中value[]存放的是字符】
        //  所以可以直接更新指定位置的字符而不是和String一样只能通过更新value[]存放的地址   【String中value[]存放的是指向常量池中字符的地址】
        //  因此每次【增删改】都不必更换地址（创建新的对象）
        StringBuffer stringBuffer = new StringBuffer();
    }
}
