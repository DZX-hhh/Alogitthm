#include<bits/stdc++.h>
using namespace std;

int main() {
	string s1,s2;
	char res[1005];
	int index=0;
	cin >> s1>>s2;
	for(int i=0; i<s1.size(); i++) {
		int flag=0;
		for(int j=0; j<s2.size(); j++) {
			if(toupper(s1[i])==toupper(s2[j])) {
				flag=1;
			}
		}
		if(flag==0) {
			res[index++]=s1[i];
		}
	}
	if(index==0) {
		cout <<"Blank";
	} else {
		cout <<res;
	}
	return 0;
}
