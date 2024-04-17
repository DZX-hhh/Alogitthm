#include<bits/stdc++.h>
using namespace std;

int main() {
	int t;
	cin >> t;
	while(t--) {
		int N;
		cin >> N;
		int flag=0;
		for(int i=1; i<=100; i++) {
			for(int j=i; j<=100; j++) {
				if(pow(i,3)+pow(j,3)==N) {
					cout << i <<" "<<j<<"\n";
					flag=1;
				}
			}
		}
		if(flag==0) {
			cout <<"No Solution"<<endl;
		}
	}
	return 0;
}
