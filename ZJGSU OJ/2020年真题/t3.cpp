#include <bits/stdc++.h>
using namespace std;

//还款规则 a(1+x) - c
// a为欠款，x为利率，c为每月还款
/**
我们可以使用二分法来寻找合适的月利率
?
x。首先，设定一个月利率的范围，例如 0 到 100然后通过二分法不断缩小范围，找到使得最后一个月欠款为0的月利率。
*/
int main() {
	double a,c; //a为借款，c为每月还款
	int b; //还钱的月份
	cin >> a;
	cin >> b;
	cin >> c;
	//还款规则 a(1+x) - c

	//现在求x，这里使用二分法
	double low = 0.0;
	double high = 1.0;
	double tolerance = 1.0e-6; //精度上限

	while (high - low > tolerance) { // 精度未超过上限
		double x = (low + high) / 2.0; // 中间的利率 x, 利用二分不断靠近符合要求的利率
		cout <<"low: " << low <<"\thigh: " << high <<"\t利率x: " << x ;
		double remainingLoan = a; //当前还欠下的钱

		for (int i = 0; i < b; ++i) {
			remainingLoan = remainingLoan * (1.0 + x) - c; //还款规则，更新还款后的欠款
		}
		cout <<"\t剩下:"<< remainingLoan << endl; 

		//二分
		if (remainingLoan > 0) {
			high = x;
		} else {
			low = x;
		}
	}

	printf("%.3lf%%",low * 100); //返回月利率，保留三位小数
	return 0;
}
