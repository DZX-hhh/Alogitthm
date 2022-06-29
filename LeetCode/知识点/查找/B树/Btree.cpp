#include<bits/stdc++.h>
using namespace std;

#define N 5 //定义N叉树

typedef struct Node {
	int arr[N];//关键字
	struct Node* child[N + 1];//最多N+1个孩子
	int num;//节点中有几个关键字
}Node;
