package chapter17_Muti_Threads;

/**
 * @Author : Ly
 * @Date : 2022/3/24
 * @Description :
 */
public class CpuNum {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        int cpuNUms = runtime.availableProcessors();
        System.out.println(cpuNUms);
    }
}
