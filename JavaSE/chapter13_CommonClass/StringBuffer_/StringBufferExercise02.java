package chapter13_CommonClass.StringBuffer_;

/*
    显示商品价格，小数点前面每三位用逗号隔开
 */
public class StringBufferExercise02 {
    public static void main(String[] args) {
        test t1 = new test("手机", "1234567891011121314151617181920.00");
        System.out.println(t1);
        t1.decorate();
        System.out.println(t1);

    }
}
class test {
    private StringBuffer name;
    private StringBuffer price;

    public test(String name, String price) {
        this.name = new StringBuffer(name);
        this.price = new StringBuffer(price);
    }

    public StringBuffer getName() {
        return name;
    }

    public StringBuffer getPrice() {
        return price;
    }

    public void setName(StringBuffer name) {
        this.name = name;
    }

    public void setPrice(StringBuffer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "商品名称是 " + name +
                ", 价格是 " + price;
    }

    public void decorate(){
        if (price == null || price.length() == 0) {
            System.out.println("Error 价格为空");
            return;
        }
        //获取小数点位置
        int index = price.indexOf(".");
        //小数点前就3位 不处理
        if (price.indexOf(".") < 4)
            return;
        //确定需要添加几个逗号 3num + 1 = index
//        int num = (index - 1) / 3;
        //不需要设置一个变量 记住循环个数 抵消插入的，占位 因为是从后向前插入的
        for (int i = index - 3; i > 0 ; i = i - 3) {
            price.insert(i, ",");
        }


    }
}