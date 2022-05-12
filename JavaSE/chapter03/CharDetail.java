public class CharDetail {
	public static void main(String[] args) {
		//char 必须用单引号 string用的是双引号
		char c1 = 'a';
		char c2 = '\t';
		char c3 = '你';
		//数字直接显示unicode码
		char c4 = 97;
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		System.out.println(c4);
		//转换输出 代表字符的数字
		System.out.println((int)c1);
		System.out.println("换行");
		//字符的加法就是 数字相加 非字符串加法
		System.out.println((char)(c1 + 1));
		//直接输出就是数字
		System.out.println('a' + 1);
		//char 一下就是变成字符类型了所以输出b
		char c5 = 'a' + 1;
		System.out.println(c5);
		
		boolean tag = true;
		//boolean 必须为true false 或null 不能用数字表示
		if (tag == 1) { //错的
			System.out.println("哈哈哈");
		}
		
	}
}