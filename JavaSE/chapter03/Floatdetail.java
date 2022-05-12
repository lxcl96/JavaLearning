public class Floatdetail {
	public static void main(String[] args) {
		double n1 = 2.7;
		double n2 = 8.1;
		
		System.out.println(n2 / 3);
		System.out.println(n1 - n2 / 3);
		if(n1 == n2 / 3) {
			System.out.println("相同-1");
		}
		//小数的比较应该是以两个数的差值的绝对值，在某个精度范围内判断
		//差值非常小 到规定的精度就认为是相同的
		if(Math.abs(n1 - n2 / 3) < 0.00000001) {
			System.out.println("相同-2");
		}
	}
}