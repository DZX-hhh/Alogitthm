#include <bits/stdc++.h>
using namespace std;

int main() {
	int a;
	cin >> a; //��֪�ŵ�����
	int max,min;//���/���ж���ֻ����
	//��Խ�࣬����Խ��
	max =  a/2; //ȫ�Ǽ�
	//����Խ�࣬����Խ��
	if(a%4==0) { //˵������ȫ������
		min = a/4;//ȫ������
	} else {
		min = 1 + (a-2) / 4; // ��һֻ����ʣ�µĶ�������
	}
	if(a%2==0) {
		cout << min << " " << max;
	} else {
		cout << "0 0";
	}
	return 0;
}
