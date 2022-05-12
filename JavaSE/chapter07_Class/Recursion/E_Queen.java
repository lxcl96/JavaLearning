package chapter07_Class.Recursion;

public class E_Queen {
    public static void main(String[] args) {
        //初始化一个 一维数组
        // 规定：下标表示行 值表示放在第几个位置 从0开始
        int queenMap[] = new int[8];
        Queen q = new Queen();
        q.SetPosition(queenMap, 0);


    }
}
// 自己尝试写 方法错误
class Queen {

    //摆放 arr表示地图 i表示第几行
    public void SetPosition(int arr[], int cur) {
        //放完了 返回true
        if (cur >= arr.length) {
            for (int n: arr)
                System.out.print(n + " ");
            System.out.println();
            return;
        }

        //从第一列开始赋值 一个一个尝试 ***下标为行 值为列
        for (int col= 0; col < arr.length; col++){
            // 执行break 条件
            boolean correct = true;
            arr[cur] = col; //表示此点坐标（cur,col） 这个代表（A,B）最高的
            //再去已有的 存好的 去判断
            for (int row = 0; row < cur; row++){
                //如果找到相同的值 代表已经走过的每行存放的位置 判断是不是 (A-X,B+X) (A+X,B+X)
                // 此时 已存在的这个点坐标为（row,arr[row]）
                //如果在同一列 或在同一条斜线上 跳出 row循环 表示不对
                if (arr[cur] == arr[row] || cur - row == Math.abs(col - arr[row])) {
                    correct = false;
                    break;
                }
            }
            //这一个找到满意的了 不再继续 开始下一行
            if (correct)
                SetPosition(arr, cur + 1);
        }
        //这一个找到满意的了 找下一个位置放在这错了  SetPosition(arr, cur + 1);

    }
}