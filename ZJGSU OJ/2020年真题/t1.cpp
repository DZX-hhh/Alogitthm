#include<bits/stdc++.h>
using namespace std;

int main() {
	int score; // �÷�
	int A=0;//����ĸ���
	int B=0;// �еȵĸ���
	int C=0;//������ĸ���
	while(cin >> score && score > 0) { //һ��ѧ���ĳɼ�
		if(score>=85) {
			A++; //����
		} else if(score >= 60) {
			B++; //�е�
		} else {
			C++; //������
		}
	}
	cout << ">=85:" << A << endl;
	cout << "60-84:" << B << endl;
	cout << "<60:" << C << endl;
	return 0;
}
