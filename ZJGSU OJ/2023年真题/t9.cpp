#include<bits/stdc++.h>
using namespace std;

int main() {
	int n;
	cin>>n;
	double res=0;
	//������acos-1
	double PI =acos(-1);
	//ֱ��Χ��Բ
	res= PI*pow(n/(2.0*PI),2);
	printf("%.3lf",res);
	return 0;
}
