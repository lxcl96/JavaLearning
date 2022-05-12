package chapter08_intermediate.Extends.Exercise;

public class ExtendsExercise03 {
    public static void main(String[] args) {

    }
}
// 以后一般默认就是 private
class Computer {
    String cpu;
    String memory;
    String disk;

    public String getDetail() {
        return "cpu是" + cpu + " 内存是" + memory + " 硬盘是" + disk;
    }
}
class PC extends Computer {
    String brands;

    public void info() {
        System.out.println(getDetail() + " 品牌是" + brands);
    }
}
class NotePad extends Computer {
    String color;

    public void info() {
        System.out.println(getDetail() + " 颜色是" + color);
    }
}
class Test {
    public static void main(String[] args) {
        PC pc = new PC();
        NotePad notePad = new NotePad();
        pc.brands = "apple";
        pc.cpu = "M1X";
        pc.memory = "16G";
        pc.disk = "512G";
        pc.info();
        System.out.println("===================");
        notePad.color = "月光白";
        notePad.info();
    }
}