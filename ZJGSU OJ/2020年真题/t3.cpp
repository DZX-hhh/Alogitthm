#include <bits/stdc++.h>
using namespace std;

//������� a(1+x) - c
// aΪǷ�xΪ���ʣ�cΪÿ�»���
/**
���ǿ���ʹ�ö��ַ���Ѱ�Һ��ʵ�������
?
x�����ȣ��趨һ�������ʵķ�Χ������ 0 �� 100Ȼ��ͨ�����ַ�������С��Χ���ҵ�ʹ�����һ����Ƿ��Ϊ0�������ʡ�
*/
int main() {
	double a,c; //aΪ��cΪÿ�»���
	int b; //��Ǯ���·�
	cin >> a;
	cin >> b;
	cin >> c;
	//������� a(1+x) - c

	//������x������ʹ�ö��ַ�
	double low = 0.0;
	double high = 1.0;
	double tolerance = 1.0e-6; //��������

	while (high - low > tolerance) { // ����δ��������
		double x = (low + high) / 2.0; // �м������ x, ���ö��ֲ��Ͽ�������Ҫ�������
		cout <<"low: " << low <<"\thigh: " << high <<"\t����x: " << x ;
		double remainingLoan = a; //��ǰ��Ƿ�µ�Ǯ

		for (int i = 0; i < b; ++i) {
			remainingLoan = remainingLoan * (1.0 + x) - c; //������򣬸��»�����Ƿ��
		}
		cout <<"\tʣ��:"<< remainingLoan << endl; 

		//����
		if (remainingLoan > 0) {
			high = x;
		} else {
			low = x;
		}
	}

	printf("%.3lf%%",low * 100); //���������ʣ�������λС��
	return 0;
}
