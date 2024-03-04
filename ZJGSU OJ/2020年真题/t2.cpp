#include <bits/stdc++.h>
using namespace std;

int main() {
	int a;
	cin >> a; //已知脚的数量
	int max,min;//最多/少有多少只动物
	//鸡越多，动物越多
	max =  a/2; //全是鸡
	//兔子越多，动物越少
	if(a%4==0) { //说明可以全是兔子
		min = a/4;//全是兔子
	} else {
		min = 1 + (a-2) / 4; // 有一只鸡和剩下的都是兔子
	}
	if(a%2==0) {
		cout << min << " " << max;
	} else {
		cout << "0 0";
	}
	return 0;
}
