#include<bits/stdc++.h>
using namespace std;

int main() {
	int xa,ya,xb,yb;
	cin>>xa>>ya>>xb>>yb;
	int n;
	cin>>n;
	int res=0;
	while(n--) {
		int xi,yi;
		cin>>xi>>yi;
		if((xi-xa)*(yb-ya) == (xb-xa)*(yi-ya)) {
			res++;
		}
	}
	cout << res;
	return 0;
}
