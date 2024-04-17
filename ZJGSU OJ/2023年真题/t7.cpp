#include<bits/stdc++.h>
using namespace std;

int fa[1005];

void init(int n) {
	for(int i=1; i<=n; i++) {
		fa[i]=i;
	}
}
//找他祖宗
int find(int x) {
	if(fa[x]==x) {
		return x;
	}
	return find(fa[x]);
}
//合并祖宗
void merge(int i,int j) {
	fa[find(i)]=find(j);
}
//n个人，m个人相互认识，也就是可以合并
void fun(int n,int m) {
	init(n);
	int res=0;
	for(int i=0; i<m; i++) {
		//合并两个认识的人。
		int a,b;
		cin>>a>>b;
		merge(a,b);
	}
	for(int i=1; i<=n; i++) {
		if(find(i)==i) {
			//自己就是祖宗
			res++;
		}
	}
	cout << res<<endl;
}


int main() {
	int T;
	cin>>T;
	while(T--) {
		int n,m;
		cin>>n>>m;
		fun(n,m);
	}
	return 0;
}
