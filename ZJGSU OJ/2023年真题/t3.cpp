#include <bits/stdc++.h>
using namespace std;

void fun(int n) {
	int index=0;
	for(int i=1; i<=n; i++) {
		for(int j=n-i; j>0; j--) {
			cout << " ";
		}
		for(int j=0; j<i; j++) {
			char c = 'A'+(index%26);
			index++;

			if(j==(i-1))
			
			{
				cout <<c<<"\n";
			} else {
				cout <<c<<" ";
			}
		}
	}
}
int main() {
	int n;
	cin >>n;
	fun(n);
	return 0;
}
