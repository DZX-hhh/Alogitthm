#include<bits/stdc++.h>
using namespace std;
void func(int n,string s) {
	int res=0; //����
	for(int i=s.size()-1; i>=0; i--) {
		if(i==s.size()-1) {
			res+=s[i]-'0';//��0
		} else if(s[i]!='0') {
			res+=s[i]-'0';
			res++;//����λ��
		}
	}
	cout<<res<<endl;
}
int main() {
	int t;
	cin>>t;
	while(t--) {
		int n;
		cin>>n;
		string s;
		cin>>s;
		func(n,s);
	}
	return 0;
}
