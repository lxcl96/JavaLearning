public class CharDetail {
	public static void main(String[] args) {
		//char �����õ����� string�õ���˫����
		char c1 = 'a';
		char c2 = '\t';
		char c3 = '��';
		//����ֱ����ʾunicode��
		char c4 = 97;
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		System.out.println(c4);
		//ת����� �����ַ�������
		System.out.println((int)c1);
		System.out.println("����");
		//�ַ��ļӷ����� ������� ���ַ����ӷ�
		System.out.println((char)(c1 + 1));
		//ֱ�������������
		System.out.println('a' + 1);
		//char һ�¾��Ǳ���ַ��������������b
		char c5 = 'a' + 1;
		System.out.println(c5);
		
		boolean tag = true;
		//boolean ����Ϊtrue false ��null ���������ֱ�ʾ
		if (tag == 1) { //���
			System.out.println("������");
		}
		
	}
}