package chapter05_LogicDecision;

public class HomeWork01 {
    public static void main(String[] args) {
        double cashLeft = 100000;
        int crossRoad = 0;
        while (cashLeft > 0) {
            if (cashLeft > 50000) {
                cashLeft *= 0.95;
                crossRoad++;
                // 还要考虑到 手里的钱够不够 交的路费 1000
            } else if (1000 <= cashLeft && cashLeft <= 50000) {
                cashLeft -= 1000;
                crossRoad++;
            } else
                break;
        }
        System.out.println("该人可以经过" + crossRoad + "次路口，剩下" + cashLeft + "钱");
    }
}
