#include<bits/stdc++.h>
using namespace std;

const int N = 10;

int high[N];
int parent[N];

void init(int n) {
	for (int i = 0; i < n; i++) {
		parent[i] = -1;
	}
}

int find(int i) {

	/* 普通查找 */
	/* while (parent[i] >= 0) {
		i = parent[i];
	}
	return i; */

	/* 路径压缩 */
	if (parent[i] >= 0) {
		parent[i] = find(parent[i]);//让父节点指向父节点的父节点
	}
	return i;
}

void UF(int i, int j) {
	//直接合并
	parent[i] = j;

	/* 按秩合并 */
	i = find(i);
	j = find(j);
	if (i == j) {
		return;
	}
	if (high[i] > high[j]) {
		parent[j] = i;
	} else {
		parent[i] = j;
		if (high[i] == high[j]) {
			high[j]++;
		}
	}
}