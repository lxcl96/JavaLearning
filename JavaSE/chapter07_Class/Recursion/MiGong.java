package chapter07_Class.Recursion;

import org.jetbrains.annotations.NotNull;

public class MiGong {
    public static void main(String[] args) {
        //8x7迷宫 int map[][] = new int[8][7];
        /*
            规定：0表示可以走的路，1表示障碍物不能走 迷宫如下
                从[0][0]走到[7][6]只走 0
            1 1 1 1 1 1 1
            1 0 0 0 0 0 1
            1 0 0 0 0 0 1
            1 1 1 0 0 0 1
            1 0 0 0 0 0 1
            1 0 0 0 0 0 1
            1 0 0 0 0 0 1
            1 1 1 1 1 1 1

         */
        int map[][] = new int[8][7];
        MGSetting miSet = new MGSetting();
        miSet.MGPrint(map);
//        miSet.Extreme(map);
        System.out.println("迷宫初始化:");
        miSet.MGInitial(map);
        miSet.MGPrint(map);
        System.out.println("迷宫找路:");
        miSet.findWay2(map, 1 ,1);
//        miSet.findWany2(map, 1 , 1);
        miSet.MGPrint(map);
    }
}

class MGSetting {
    //打印迷宫
    public void MGPrint(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    //初始化迷宫
    public void MGInitial(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (i == 0 || i == 7)
                    arr[i][j] = 1;
                if (j == 0 || j == 6)
                    arr[i][j] = 1;
            }
        }
        arr[3][1] = 1;
        arr[3][2] = 1;
    }
    //极端情况
    /*
            1 1 1 1 1 1 1
            1 0 1 0 0 0 1
            1 0 1 0 0 0 1
            1 1 1 0 0 0 1
            1 0 0 0 0 0 1
            1 0 0 0 0 0 1
            1 0 0 0 0 0 1
            1 1 1 1 1 1 1
     */
    public void Extreme(int arr[][]) {
        arr[1][2] = 1;
        arr[2][2] = 1;
    }
    //找路 初始位置为map[1][1] 走到map[6][5]
    // 0表示可以走的路，未走，1表示障碍物不能走  2表示走过的路，不是死路  3表示走过的路，为死路
    //当map[6][5] = 2则表示找到出路 退出递归
    //找路的策略：下-》右-》上-》左
    public boolean findWay(int map[][], int i, int j) {
        //找到出路直接退出
        if (map[6][5] == 2)
            return true;
        //判断路
        if (map[i][j] == 0) {
            //表示可以走的路，未走 假定可走
            map[i][j] = 2;
            //开始探测 此点是否可以通路探测 下-》右-》上-》左
            //先下
            if (findWay(map, i + 1, j))
                return true;
            //再 右
            if (findWay(map, i, j + 1))
                return true;
            //再 上
            if (findWay(map, i - 1, j))
                return true;
            //再 左
            if (findWay(map, i, j - 1))
                return true;
            //否则表示 此路不同
            map[i][j] = 3;
            //当前位置返回错误
            return false;
        }
        // 表示当前值 map[i][j] 为1 或2 或3 当前已经测试过了 就不要再走了
        return false;
    }

    //查找；路线右-》下-》左-》上
    public boolean findWany2(int map[][], int i, int j) {
        //第一个必须是递归退出
        if (map[6][5] == 2)
            return true;// 找到出路了

        //代表有路走 但是没有走过
        if (map[i][j] == 0) {
            //假设此位置可以走通
            map[i][j] = 2;
            //尝试按照 路线右-》下-》左-》上 切能走通
            if (findWany2(map, i, j + 1))
                return true;
            if (findWany2(map, i + 1, j))
                return true;
            if (findWany2(map, i, j - 1))
                return true;
            if (findWany2(map, i - 1, j))
                return true;
            //否则上下左右都没有路 代表死路
            map[i][j] = 3;
            return false;
        }
        //此时map[i][j] = 1/2/3 代表走过或者没路
        return false;
    }

    //查找；路线上-》右-》下-》左
    public boolean findWay2(int map[][], int i, int j) {
        //第一个必须是递归退出
        if (map[6][5] == 2)
            return true;// 找到出路了

        //代表有路走 但是没有走过
        if (map[i][j] == 0) {
            //假设此位置可以走通
            map[i][j] = 2;
            //尝试按照 路线上-》右-》下-》左 切能走通
            if (findWany2(map, i - 1, j))
                return true;
            if (findWany2(map, i, j + 1))
                return true;
            if (findWany2(map, i + 1, j))
                return true;
            if (findWany2(map, i, j - 1))
                return true;
            //否则上下左右都没有路 代表死路
            map[i][j] = 3;
            return false;
        }
        //此时map[i][j] = 1/2/3 代表走过或者没路
        return false;
    }
}
