#include<bits/stdc++.h>
using namespace std;

int fa[1005];

void init(int n) {
	for(int i=1; i<=n; i++) {
		fa[i]=i;
	}
}
//��������
int find(int x) {
	if(fa[x]==x) {
		return x;
	}
	return find(fa[x]);
}
//�ϲ�����
void merge(int i,int j) {
	fa[find(i)]=find(j);
}
//n���ˣ�m�����໥��ʶ��Ҳ���ǿ��Ժϲ�
void fun(int n,int m) {
	init(n);
	int res=0;
	for(int i=0; i<m; i++) {
		//�ϲ�������ʶ���ˡ�
		int a,b;
		cin>>a>>b;
		merge(a,b);
	}
	for(int i=1; i<=n; i++) {
		if(find(i)==i) {
			//�Լ���������
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
