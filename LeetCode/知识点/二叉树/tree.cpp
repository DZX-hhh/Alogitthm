#include<bits/stdc++.h>
using namespace std;

#define MAX_TREE_SIZE 100 //数的最多节点数

typedef int ElemType;

/* 双亲表示法(顺序存储):适合找双亲 */
typedef struct {
	ElemType data;//数据元素
	int Parent;//指向双亲位置域
}PtNode;
typedef struct {//数的类型定义
	PtNode nodes[MAX_TREE_SIZE];//双亲表示法(顺序存储)
	int n; //节点数
}Ptree;



/* 孩子表示法(顺序存储各节点+链式存储孩子头指针):适合找孩子*/
typedef struct CtNode {
	int Location;//节点在数组中的位置
	struct CtNode* Children;//下一个孩子(兄弟节点)
}CtNode;
typedef struct CtBox {
	ElemType data;
	CtNode* FirstChild;//第一个孩子
}CtBox;
typedef struct CTree {
	CtBox Nodes[MAX_TREE_SIZE]; //顺序表
	int n;//节点数
	int root;//根节点的位置
};



/* 左孩子右兄弟表示法(链式存储):可以用熟悉的二叉树处理树 */
typedef struct CsNode {
	ElemType data;//数据域
	struct CsNode* Firstchild, * Brothers;//第一个孩子和右兄弟指针
}CsNode, * CsTree;


//1.深度优先遍历(树)
//先序遍历树序列 = 先序遍历对应二叉树序列
/*
void PreOrder(TreeNode *root) {
	if (root != NULL) {
		visit(root);
		while (root还有下一个子树) {
			PreOrder(root->Childrens);
		}
	}
}
*/

//后根遍历树(先访问子树,再访问根节点)序列 = 中序遍历对应二叉树序列
/*
void PostOrder(TreeNode* root) {
	if (root != NULL) {
		while (root还有下一个子树) {
			PostOrder(root->Children);
		}
		visit(root);
	}
}
*/

//2.广度优先遍历(树)
//层序遍历 :队列入队出队

//森林的先序遍历序列  = 对应左孩子右兄弟的二叉树的先序遍历序列 = 各个树先序遍历序列    根节点-孩子森林-兄弟森林

//森林的中序遍历序列  = 对应左孩子右兄弟的二叉树的中序遍历序列 = 各个树后序遍历遍历    孩子森林-根节点-兄弟森林