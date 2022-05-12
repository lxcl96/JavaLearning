package chapter08_intermediate;

public class test {

    public static void main(String[] args) {
        int[] a = {-1, 2, 0, -2, 10};
        int tmp = 0;

        //从大到小
        for (int i = 0; i < a.length -1; i++) {
            for (int j = 0; j < a.length - 1- i; j++) {
                    if (a[j] < a[j + 1]) {
                        tmp = a[j];
                        a[j] = a[j + 1];
                        a[j + 1] = tmp;
                    }
            }
        }

//        for(int n : a)
//            System.out.print(n + " ");


        System.out.println(new test().getClass());
        System.out.println(new test().getClass().getName());
    }
}
