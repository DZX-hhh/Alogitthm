#include <bits/stdc++.h>
using namespace std;

int a[100][100];

void pr(int n) {
	for(int i=0; i<n; i++) {
		for(int j=0; j<n; j++) {
			if(j==0||i==j||i+j==n-1||i==n-1||j==n-1) {
				a[i][j]=1;
			}
		}
	}

	for(int i=0; i<n; i++) {
		for(int j=0; j<n; j++) {
			if(a[i][j]==1&&j<n-1) {
				cout <<"*"<<" ";
			} else if(j==n-1) {
				cout<<"*" <<"\n";
			} else {
				cout <<"  ";
			}
		}
	}
}
int main() {
	int n;
	cin>>n;
	pr(n);
	return 0;
}
