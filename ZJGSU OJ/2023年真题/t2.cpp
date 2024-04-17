#include<bits/stdc++.h>
using namespace std;

int main() {
	string s;
	while(cin>>s) {
		sort(s.begin(),s.end());
		for(int i=0; i<s.size(); i++) {
			cout<<s[i];
			if(i<s.size()-1) {
				cout <<" ";
			}
		}
		cout<<"\n";
	}
	return 0;
}
