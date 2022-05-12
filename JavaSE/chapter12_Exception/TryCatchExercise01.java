package chapter12_Exception;

public class TryCatchExercise01 {
    public static void main(String[] args) {
        System.out.println(method());//我觉得答案是：3 实际答案是4 因为finally必须执行所以return没有结束
    }


    public static int method() {
        try {
            String[] names = new String[3];
            if (names[1].equals("tom")) {
                System.out.println(names[1]);
            } else {
                names[3] = "hahah";
            }
            return 1;
        } catch (ArrayIndexOutOfBoundsException e) {
            return 2;
        } catch (NullPointerException e) {
            return 3;
        } finally {
            return 4;
        }
    }
}
