#include <bits/stdc++.h>
using namespace std;

bool isNum(int n) { //判断这个是否是"守形数"
	long long square = n * n; // n的平方数,long long避免溢出
	while(n>0) {
		if(n % 10 != square % 10) { //判断最后一位数
			return false; //不符合
		}
		//最后一位符合要求，则更新到前（左）一位
		n /= 10;
		square /= 10;
	}
	return true;
}
bool isNum2(int n) {
	long long square = n * n;
	string s = to_string(n); //转化成字符串 
	string ss = to_string(square); 
	int w = s.size(); // 字符串长度，数字位数 
	int ww = ss.size();
	for(int i=0; i<w; i++) {
		if(s[i] != ss[ww-w + i]) { // 按照对应的位置比较 
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
