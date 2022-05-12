package chapter07_Class.Recursion;

public class E_Queen3 {
    public static void main(String[] args) {
        //再写一遍八皇后 用一维数组保存位置
        int max = 8;//定义棋局大小
        int queen[] = new int[max];
        Method me = new Method();
        //从第0行开始
        me.place(queen, 0);
        System.out.println("最后数组状态：");
        for (int n:queen)
            System.out.print(n + " ");//最后结果为77777777 因为这个找出所有的摆放方式 第一个位置从0-7一个个尝试
    }
}
/*
	(A-X,A-X)	(A+X,A-X)
			(A,A)
	(A-X,A+X)	(A+X,A+X)
	可以发现规律 ：同一斜线上 两点x轴座标差的绝对值 和 y轴坐标差的绝对值相同
 */
class Method {
    public void print(int arr[]) {
        for (int k:arr)
            System.out.print(k + " ");
        System.out.println();
    }
    //arr表示棋局  n表示开始的位置(第几行)
    public void place(int arr[], int n) {
        //递归先找出 出口 如果是最后一行 +1 退出（下标从0开始）
        if (n == arr.length) {
            //在此处输出一次的答案
            //这是因为 说明找到最后一个 +1 的位置了 从0-7放置的值都是正确的即一次正确答案，输出 下面开始下个位置
            print(arr);//为什么在 这一部 才是输出正确的答案呢？
            return;
        }

        //一个位置一个位置尝试  看看有无问题 一个赋值一个检查 可以发现是双重for循环
        //列从0-7一个一个尝试
        for (int i = 0; i < arr.length; i++) {
            boolean state = true;//此点是否可以放 默认可以
            arr[n] = i;//循环的 此时被比较点坐标为(n, i)或（n,arr[n]）
            //开始检查 从已经保存的数组 逐个开始 此时n之前的位置已确定
            for (int j = 0; j < n; j++) {//此时比较点的坐标为 (j,arr[j])
                //值相同表示同一个位置   两点x轴座标差的绝对值 和 y轴坐标差的绝对值相同表示同一个斜线
                if (arr[j] == arr[n] || Math.abs(n - j) == Math.abs(arr[n] - arr[j])) {
                    state = false;//不可以
                    break; //表示此点不行 需要跳出循环 i+1即arr[n]要变成下一个i
                }

            }
            //但是需要一个判断 如果没有不合适的 （就不用让i继续+1了 不然最后都是77）就开始判断下一个位置
            //假定此时找到第一个满足的点为有效点 因为有可能这个点有效但是下面就找不到 方便回溯
            //判断state状态 如果为true 开始尝试放下一个位置
            if (state)
                place(arr, n + 1);
        }
        //运行到此步 说明这种摆放没问题 直接打印即可 开始下一个位置摆放
//        print(arr);
    }
}