#include<bits/stdc++.h>
using namespace std;

int main() {
	int n;
	cin>>n;
	double res=0;
	//Π等于acos-1
	double PI =acos(-1);
	//直接围成圆
	res= PI*pow(n/(2.0*PI),2);
	printf("%.3lf",res);
	return 0;
}
