package chapter12_Exception;


/*
    优化版
 */
public class HomeWork01_ {

    public static void main(String[] args) {
        //参数由命令行 带入
        try {
            if (args.length != 2) {
                throw new ArrayIndexOutOfBoundsException("缺少命令行参数");//
            }

            int n1 = Integer.parseInt(args[0]);
            int n2 = Integer.parseInt(args[1]);

            System.out.println("n1 / n2 = " + EcmDef_.cal(n1, n2));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("数据格式异常：非int类型");
        } catch (ArithmeticException e) {
            System.out.println("算术异常：除0");
        }
    }
}

class EcmDef_ {
    public static int cal(int n1, int n2) throws ArithmeticException {
        return n1 / n2;
    }
}
