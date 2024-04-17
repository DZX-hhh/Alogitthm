#include<bits/stdc++.h>
using namespace std;

//Сд
bool rule(string s) {
	for(int i=0; i<s.size()-1; i++) {
		if(s[i]<'z'&&s[i]>'a') {
			if(s[i+1]!=toupper(s[i])
			        &&
			        s[i+1]!=(char)('a'+((s[i]-'a'+2)%26))) {
				return false;
			}
		}
		if(s[i]<'Z'&&s[i]>'A') {
			if(s[i+1]!=tolower(s[i])
			        &&
			        s[i+1]!=(char)('A'+((s[i]-'A'+24)%26))) {
				return false;
			}
		}
	}
	return true;
}
int main() {
	int n;
	cin>>n;
	while(n--) {
		string s;
		cin>>s;
//		cout<< (char)('A'+(('Z'-'A'+24)%26));
		if(rule(s)) {
			cout <<"Y"<<"\n";
		} else {
			cout <<"N"<<"\n";
		}
	}
	return 0;
}
