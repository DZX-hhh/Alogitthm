#include<bits/stdc++.h>
using namespace std;

const int R = 10;
/* 初始化关键字 */
typedef struct LinkNode {
	int data;//数据
	struct LinkNode* next;//下一个节点
}LinkNode;

/* 初始化队列链表 */
typedef struct LinkQueue {
	LinkNode* front, * rear;//队列队头队尾指针
}LinkQueue;

LinkQueue Q[R];

//稳定
//时间复杂度:O(d(n+r))