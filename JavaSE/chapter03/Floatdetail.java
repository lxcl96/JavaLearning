public class Floatdetail {
	public static void main(String[] args) {
		double n1 = 2.7;
		double n2 = 8.1;
		
		System.out.println(n2 / 3);
		System.out.println(n1 - n2 / 3);
		if(n1 == n2 / 3) {
			System.out.println("��ͬ-1");
		}
		//С���ıȽ�Ӧ�������������Ĳ�ֵ�ľ���ֵ����ĳ�����ȷ�Χ���ж�
		//��ֵ�ǳ�С ���涨�ľ��Ⱦ���Ϊ����ͬ��
		if(Math.abs(n1 - n2 / 3) < 0.00000001) {
			System.out.println("��ͬ-2");
		}
	}
}