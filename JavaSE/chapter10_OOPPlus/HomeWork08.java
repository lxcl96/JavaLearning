package chapter10_OOPPlus;

public class HomeWork08 {
    public static void main(String[] args) {
        //创建引用对象
        Color c = Color.RED;
        switch (c) {
            case RED:
                c.show();
//                break;
            case BLUE:
                c.show();
                break;
            case BLACK:
                c.show();
                break;
            case GREEN:
                c.show();
                break;
            case YELLOW:
                c.show();
        }
    }
}

interface IA {
    void show();
}
enum Color implements IA{
    RED(255,0,0),BLUE(0,0,255),
    BLACK(0,0,0),YELLOW(255,255,0),
    GREEN(0,255,0);

    private int redValue;
    private int greenValue;
    private int blueValue;

    private Color(int redValue, int greenValue, int blueValue) {
        this.redValue = redValue;
        this.greenValue = greenValue;
        this.blueValue = blueValue;
    }

    @Override
    public void show() {
        System.out.println("红绿蓝三属性值为：" + redValue + " " + greenValue + " " + blueValue);
    }
}