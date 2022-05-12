package chapter13_CommonClass;

/*
    将abcdef 交换为aedcbf
    领一个思路：char[] ch = str.toArrays()for循环交换
 */
public class HomeWork01 {

    public static String reverse(String str, int start, int end) throws Exception{
        //最好的方法是写出所有正确的情况，然后取反 throw
        if (end < start ||start < 0 || start > str.length() || end > str.length())
            throw new Exception("起始或结束位置异常，请检查！");
        //获取StringBuffer类型的字串
        String sub = str.substring(start, end + 1);
        StringBuffer sbBuffer = new StringBuffer(sub);
        sbBuffer.reverse();

        //StringBuffer 转成String
        return str.replace(sub,sbBuffer.toString());
    }

    public static void main(String[] args){

        try {
            System.out.println(reverse("abcdef", 1, 4));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
