#include<bits/stdc++.h>
using namespace std;

int main() {
	int score; // 得分
	int A=0;//优秀的个数
	int B=0;// 中等的个数
	int C=0;//不及格的个数
	while(cin >> score && score > 0) { //一批学生的成绩
		if(score>=85) {
			A++; //优秀
		} else if(score >= 60) {
			B++; //中等
		} else {
			C++; //不及格
		}
	}
	cout << ">=85:" << A << endl;
	cout << "60-84:" << B << endl;
	cout << "<60:" << C << endl;
	return 0;
}
