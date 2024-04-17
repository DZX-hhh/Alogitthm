#include<bits/stdc++.h>
using namespace std;

set<int> se;

int main() {
	int num;
	while(cin>>num) {
		se.insert(num);
	}
	for(auto num:se) {
		cout <<num<<" ";
	}
	return 0;
}
