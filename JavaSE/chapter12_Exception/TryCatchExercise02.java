package chapter12_Exception;

public class TryCatchExercise02 {
    public static void main(String[] args) {
        System.out.println(method());
        /*
        我觉得答案是： 说明返回值存在一个临时变量中，执行return时才会改变这个值
            i=4
            3
         */
    }


    public static int method() {
        int i = 1;
        try {
            i++;//i=2
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
            return ++i;//i=3
        } finally {
            ++i;
            System.out.println("i=" + i);
        }
    }
}
