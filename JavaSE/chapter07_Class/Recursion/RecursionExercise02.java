package chapter07_Class.Recursion;

public class RecursionExercise02 {
    public static void main(String[] args) {

        //有一堆桃子，猴子每天都是一半 并且多吃一个 到第十天发现只有1个了（这一天没吃） 问一共多少个桃子
        peachQuestion pe = new peachQuestion();

        System.out.println("一共有桃子" + pe.accNumber(10, 1) + "个");

    }
}
class peachQuestion {
    //day代表天数 peachSum 表示第day天剩下的桃子数量
    public int accNumber(int day, int peachSum) {
        peachSum = ( peachSum + 1 ) * 2;
        day--;
        if (day == 1)
            return peachSum;
        return accNumber(day,peachSum);
    }
}