#include<bits/stdc++.h>
using namespace std;
/*
BST又称二叉排序树
左子树 < 根节点 < 右子树
左右子树也是BST
中序遍历得到升序序列
*/

//BST,维护左小右大
typedef struct BSTNode {
	int val;
	struct BSTNode* Lchild, * Rchild;
}BSTNode, * BSTree;


BSTree root;//全局变量

//BST查找值为val的节点(非递归)
BSTNode* BST_Search1(BSTree root, int val) {
	while (root != NULL && root->val != val) {
		if (val < root->val) {
			root = root->Lchild;
		} else {
			root = root->Rchild;
		}
	}
	return root;
}
//递归版,空间复杂度O(h)
BSTNode* BST_Search2(BSTree root, int val) {
	if (root == NULL) {
		return NULL;
	}
	if (root->val == val) {//查找成功
		return root;
	} else if (root->val < val) {//右子树查找
		return BST_Search2(root->Rchild, val);
	} else {//左子树查找
		return BST_Search2(root->Lchild, val);
	}
}


//插入某个值为val的节点(递归)
int BST_Insert(BSTree root, int val) {
	if (root == NULL) {
		root = (BSTree)malloc(sizeof(BSTNode));//子树为空,,分配空间,建立新插入的节点为根节点
		root->val = val;
		root->Lchild = NULL;
		root->Rchild = NULL;
		return 1;//返回1,,插入成功
	} else if (root->val == val) {
		return 0;//存在相同val的节点,插入失败
	} else if (root->val < val) {//插到右子树
		BST_Insert(root->Rchild, val);
	} else {//插到左子树
		BST_Insert(root->Lchild, val);
	}
}

// 按照str[]中的序列"建立"BST
void Create_BSTree(BSTree root, int str[], int n) {
	root = NULL;//初始化节点
	int i = 0;
	while (i < n) {
		BST_Insert(root, str[i]);//循环插入节点
		++i;
	}
}

// 删除BST目标节点
void Delete_BSTree(BSTree root, int val) {
	//1.先找到该节点

	//2.1 该节点为叶子节点,可以直接删除
	//2.2 该节点只有左子树或右子树,则让子树代替该节点的位置
	//2.3 该节点有左右子树,用左子树最大的节点(或右子树最小的节点)移动到当前节点 (利用BST的中序为升序特性)
}



//  平均查找长度 影响查找效率,应让树的左右子树高度查不超过1,,也就是平衡二叉树
// "查找成功"的ASL = (各层的节点数 * 该层高度)之和 / 节点个数n
// "查找失败"的ASL = (各层的空节点数 * 该层高度)之和 / 空节点个数n
