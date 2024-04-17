#include<bits/stdc++.h>
using namespace std;

vector<int> arr;
int main() {
	int n;
	cin >>n;
	for(int i=0; i<n; i++) {
		int num;
		cin>>num;
		arr.push_back(num);
	}
	int m=0;
	for(auto num:arr) {
		m=max(m,num);
	}

	vector<int> max1(n,0);
	vector<int> max2(n,0);

	max1[0]=arr[0];
	for(int i=1; i<n; i++) {
		max1[i]=max(max1[i-1],arr[i]);
	}
	max2[n-1]=arr[n-1];
	for(int i=n-1; i>=1; i--) {
		max2[i-1]=max(max2[i],arr[i-1]);
	}

	int maxAbsDifference =0;

	for(int i=0; i<n-1; i++) {
		//¼ÆËã²åÖµ
		int absDiff= abs(max1[i]-max2[i+1]);
		maxAbsDifference=max(absDiff,maxAbsDifference);
	}
	cout << maxAbsDifference;
	return 0;
}
