#include<bits/stdc++.h>
using namespace std;

void pr() {
	long long x1, y1, x2, y2, x3, y3;
	cin >>x1>>y1>> x2>> y2>>x3 >> y3;
	long long ab= pow(abs(x1-x2),2)+pow(abs(y1-y2),2);
	long long ac= pow(abs(x1-x3),2)+pow(abs(y1-y3),2);
	long long bc= pow(abs(x2-x3),2)+pow(abs(y2-y3),2);
	if(ab<ac+bc) {
		cout<<"Acute";
	}
	if(ab>ac+bc) {
		cout<<"Obtuse";
	}
	if(ab==ac+bc) {
		cout <<"Right";
	}
	cout <<"\n";
}

int main() {
	int n;
	cin >>n;
	while(n--) {
		pr();
	}
	return 0;
}
