package chapter08_intermediate._object_srcCode;

public class Equals {
    public static void main(String[] args) {
        "hello".equals("abc");
        Integer n =1;
        System.out.println(n.equals(1));
        //if (this == anObject) { this表示当前对象，this.age比表示属性 this.sum()表示方法
        /*
        String.java类中equals 比较只
        public boolean equals(Object anObject) {
        if (this == anObject) {
            return true;
        }
        if (anObject instanceof String) {
            String anotherString = (String)anObject;
            int n = value.length;
            if (n == anotherString.value.length) {
                char v1[] = value;
                char v2[] = anotherString.value;
                int i = 0;
                while (n-- != 0) {
                    if (v1[i] != v2[i])
                        return false;
                    i++;
                }
                return true;
            }
        }
        return false;
         */


        /*
        看看父类Object 被重写的方法 只判断引用是不是同一个对象 即地址是否相同
        public boolean equals(Object obj) {
        return (this == obj);
    }
         */

        /*
        看看Integer 重写的方法
        public boolean equals(Object obj) {
        if (obj instanceof Integer) {
            return value == ((Integer)obj).intValue();
        }
        return false;
    }

         */
    }
}
