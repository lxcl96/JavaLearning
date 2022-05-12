package chapter07_Class.Recursion;

public class E_Queen2 {
    public static void main(String[] args) {
        //初始化一个 一维数组
        // 规定：下标表示行 值表示放在第几个位置 从0开始
        int max = 8;
        int queenMap[] = new int[max];
        Queen2 q = new Queen2();
        q.SetPosition2(queenMap, 0);


    }
}

class Queen2 {
/*

	(A-X,B-X)	(A+X,B-X)
			(A,B)
	(A-X,B+X)	(A+X,B+X)
在一行或一列 (A-X,B-X) - (A,B) = (-X,-X)
即判断每个点是不是在一行一列 只要两个点的  横坐标之差绝对值 等于 纵座标之差绝对值
*/

    public void print(int arr[]) {
        for (int n: arr)
            System.out.print(n + " ");
        System.out.println();
    }
    //摆放 arr表示地图 i表示第几行 cur当前行 row 行 col列
    public void SetPosition2(int arr[], int cur) {
        if (cur == arr.length){
            print(arr);
            return;
        }

        //从第一列开始赋值 一个一个尝试 ***下标为行 值为列
        for (int col= 0; col < arr.length; col++){
            // 执行break 条件
            arr[cur] = col; //表示此点坐标（cur,col） 这个代表（A,B）最高的
            //再去已有的 存好的 去判断
            if (judge(arr, cur))
                //这一个找到满意的了 找下一个位置
                SetPosition2(arr, cur + 1);
        }
    }

    public boolean judge(int arr[], int cur ) {
        for (int row = 0; row < cur; row++){
            //如果找到相同的值 代表已经走过的每行存放的位置 判断是不是 (A-X,B+X) (A+X,B+X)
            // 此时 已存在的这个点坐标为（row,arr[row]）
            //如果在同一列 或在同一条斜线上 跳出 row循环 表示不对

            //看来条件不对 arr[cur] == arr[row] || cur - row == Math.abs(arr[cur] - arr[row])
            if (arr[cur] == arr[row] || Math.abs(cur - row) == Math.abs(arr[cur] - arr[row])) {
                return false;
            }
        }
        return true;
        //这一个找到满意的了 不再继续 开始下一行
    }
}