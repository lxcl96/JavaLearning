package chapter07_Class.Recursion;

public class HanoiTower {
    public static void main(String[] args) {
        //汉诺塔
        MoveTower tower = new MoveTower();
        tower.move(10,'A', 'B', 'C');
    }
}

class MoveTower {

    //num表示要移动的个数 abc表示三根柱子 从a柱子 移动到 c柱子
    public void move(int num, char a, char b, char c) {
        //如果只有一个盘子
        if (num == 1)
            System.out.println(a + " -> " + c);
        else {
            //如果有多个盘 可以看做是两个盘 底下最大的一个和所有
            //1、先移动上面所有的盘子到b 借助c
            //2、直接把最后a上的盘子移动到c 走上面
            //3、把b上盘子移动到a 借助c
            move(num - 1, a, c, b);
            move(1, a, b, c);
//            System.out.println(a + " -> " + c);
            move(num - 1, b, c, a);
        }


    }
}