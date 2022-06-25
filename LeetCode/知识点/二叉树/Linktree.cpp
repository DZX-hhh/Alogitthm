#include <bits/stdc++.h>
using namespace std;

struct ElemType {
	int value;
};

/*
二叉树的节点以及数根节点
*/
typedef struct BiTNode {
	ElemType data;
	struct BiTNode* Lchild, * Rchild;
	/* struct BiTNode* Parent; //三叉链表,,方便寻找父节点*/
} BiTNode, * BiTree;

//初始化根节点
void InitTree(BiTree root) {
	root = (BiTree)malloc(sizeof(BiTNode));
	root->data = { 1 };
	root->Lchild = NULL;
	root->Rchild = NULL;
}

//插入节点
void InsertLeftNode(BiTree root, BiTNode* node) {
	node = (BiTNode*)malloc(sizeof(BiTNode));
	node->data = { 2 };
	node->Lchild = NULL;
	node->Rchild = NULL;
	root->Lchild = node;//root左孩子
}
void InsertRightNode(BiTree root, BiTNode* node) {
	node = (BiTNode*)malloc(sizeof(BiTNode));
	node->data = { 3 };
	node->Lchild = NULL;
	node->Rchild = NULL;
	root->Rchild = node;//root左孩子
}

//访问节点
void visit(BiTNode* node) {
	cout << node->data.value << endl;
}

/*
	先序遍历O(h)
*/
void PreOrder(BiTree root) {
	if (root != NULL) {
		visit(root);//访问根节点
		PreOrder(root->Lchild);//递归遍历左子树
		PreOrder(root->Rchild);//递归遍历右子树
	}
}
/*
	中序遍历
*/
void InOrder(BiTree root) {
	if (root != NULL) {
		InOrder(root->Lchild);
		visit(root);
		InOrder(root->Rchild);
	}
}
/*
	后序遍历
*/
void PostOrder(BiTree root) {
	if (root == NULL) {
		PostOrder(root->Lchild);
		PostOrder(root->Rchild);
		visit(root);
	}
}

/*
	层序遍历
*/
void LevelOrder(BiTree root) {
	queue<BiTNode*> LinkQueue;
	BiTree outNode;
	LinkQueue.push(root);
	while (!LinkQueue.empty()) {
		outNode = LinkQueue.front();
		LinkQueue.pop();
		visit(outNode);
		if (outNode->Lchild != NULL) {
			LinkQueue.push(outNode->Lchild);
		}
		if (outNode->Rchild) {
			LinkQueue.push(outNode->Rchild);
		}
	}
}

int treeDepth(BiTree root) {
	if (root == NULL) {
		return 0;
	} else {
		int LDepth = treeDepth(root->Lchild);
		int RDepth = treeDepth(root->Rchild);
		return max(LDepth, RDepth) + 1; 
	}
}
int main() {
	//定义一颗空树
	BiTree root = NULL;
	InitTree(root);

	//插入节点
	BiTNode* node;
	InsertLeftNode(root, node);
	InsertRightNode(root, node);


	return 0;
}