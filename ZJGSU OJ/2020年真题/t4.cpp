#include <bits/stdc++.h>
using namespace std;

bool isNum(int n) { //�ж�����Ƿ���"������"
	long long square = n * n; // n��ƽ����,long long�������
	while(n>0) {
		if(n % 10 != square % 10) { //�ж����һλ��
			return false; //������
		}
		//���һλ����Ҫ������µ�ǰ����һλ
		n /= 10;
		square /= 10;
	}
	return true;
}
bool isNum2(int n) {
	long long square = n * n;
	string s = to_string(n); //ת�����ַ��� 
	string ss = to_string(square); 
	int w = s.size(); // �ַ������ȣ�����λ�� 
	int ww = ss.size();
	for(int i=0; i<w; i++) {
		if(s[i] != ss[ww-w + i]) { // ���ն�Ӧ��λ�ñȽ� 
			return false;
		}
	}
	return true;
}
int main() {
	int n;
	while(cin >> n) {
		if(isNum2(n)) {
			cout << "Yes" << endl;
		} else {
			cout << "No" << endl;
		}
	}
	return 0;
}
