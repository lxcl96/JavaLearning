import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author : Ly
 * @Date : 2022/5/10
 * @Description :
 */
public class test {
    public static void main(String[] args) {
        System.out.println("DDBH" + new SimpleDateFormat("yyyyMMddhhmmssSS").format(new Date()) + "1");
    }
}
