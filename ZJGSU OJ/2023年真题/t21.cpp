#include<bits/stdc++.h>
using namespace std;
int a[100][100];
void pr(int n) {
	for(int i=0; i<n; i++) {
		for(int j=0; j<n; j++) {
			if(i==j||i+j==n-1||j==0||j==n-1||i==n-1) {
				a[i][j]=1;
			}
		}
	}
	for(int i=0; i<n; i++) {
		for(int j=0; j<n; j++) {
			if(a[i][j]==1) {
				cout<<"*";
				if(j==n-1) {
					cout<<"\n";
				} else {
					cout<<" ";
				}
			} else {
				cout<<"  ";
			}

		}
	}
}
void fu(int n) {
	double pi = acos(-1);
	double res= pi*pow(n/(2*pi),2);
	printf("%.3lf",res);
}
void fun(string s) {
	for(int i=0; i<s.size()-1; i++) {
		if(s[i]<='z'&&s[i]>='a') {
			if(s[i+1]!=toupper(s[i])&&s[i+1]!='a'+((s[i]-'a'+2)%26)) {
				cout<<"N"<<endl;
				return ;
			}
		} else if(s[i]>='A'&&s[i]<='Z') {
			if(s[i+1]!=tolower(s[i])&&s[i+1]!='A'+((s[i]-'A'+24)%26)) {
				cout<<"N"<<endl;
				return ;
			}
		}
	}
	cout<<"Y"<<endl;
}
int main() {
	int n;
	cin>>n;
	vector<int> nums;
	for(int i=0; i<n; i++) {
		int num;
		cin>>num;
		nums.push_back(num);
	}
	vector<int> lmax(n,0);
	vector<int> rmax(n,0);
	lmax[0]=nums[0];
	rmax[n-1]=nums[n-1];
	for(int i=1; i<n; i++) {
		lmax[i]=max(lmax[i-1],nums[i]);
	}
	for(int i=n-1; i>0; i--) {
		rmax[i-1]=max(rmax[i],nums[i-1]);
	}
	int maxnum=0;
	for(int i=0; i<n-1; i++) {
		maxnum=max(maxnum,abs(lmax[i]-rmax[i+1]));
	}
	cout<<maxnum;
	return 0;
}
