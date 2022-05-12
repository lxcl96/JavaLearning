package chapter10_OOPPlus.main_;

public class hello {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            //命令行 执行
            System.out.println("第" + (i + 1) + "个参数是：" + args[i]);
        }
        System.out.println("结束");
    }
}


//防放在 锤子边的 “edit configuration ” - “program arguments”