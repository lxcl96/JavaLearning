package chapter12_Exception;

public class TryCatchDtail {
    public static void main(String[] args) {
        try {
            String str = "hello";
//            int a = Integer.parseInt(str);
            System.out.println("try结束");
//            int n1 = 10 / 0;
            int a = Integer.parseInt(str);
        } catch (ArithmeticException a){
            System.out.println(a);
        } catch (NumberFormatException n) {
            System.out.println(n);
        } catch (Exception e) {
            System.out.println("异常信息：" + e);
        } finally {
            System.out.println("不管是否出现异常都会出现此段话。");
        }
    }
}
