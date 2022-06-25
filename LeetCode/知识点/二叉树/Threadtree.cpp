#include<bits/stdc++.h>
using namespace std;

/*
	总结:
		中序遍历线索二叉树,由于左孩子可以是前驱,右孩子可以是后继,,因此可以找到中序遍历前驱和后继
		先序遍历线索二叉树,由于左右孩子都不可能是前驱,因此Ltag=0时无法找到前驱,,但是可以找到后继节点
		后序遍历线索二叉树,由于左右孩子都不可能是后继,因此Rtag=0时无法找到后驱,,但是可以找到前驱节点
*/

typedef int ElemType;

/* 普通二叉树节点 */
typedef struct BiTNode {
	ElemType data;
	struct BiTNode* Lchild, * Rchild;
}BiTNode, * BiTree;

/* 线索二叉树节点
充分利用n个节点的n+1个空指针
*/
typedef struct ThreadNode {
	ElemType data;
	struct ThreadNode* Lchild, * Rchild;
	int Ltag, Rtag;//左右线索标志位,为1时,左指针指向的是遍历前驱节点
}ThreadNode, * Threadtree;



BiTNode* target1, * pre1 = NULL, * res1 = NULL;
ThreadNode* target2, * pre2 = NULL, * res2 = NULL;



// 原始方法实现找到前驱:定义pre指针指向当前节点的前驱节点
// 遍历时,前驱节点指向当前节点,当前节点指向后继节点
void InOrder(BiTree root) {
	if (root != NULL) {
		InOrder(root->Lchild);
		visit1(root);
		InOrder(root->Rchild);
	}
}

//中序遍历二叉树,一边遍历一边线索化
void InThread(Threadtree root) {
	if (root != NULL) {
		InThread(root->Lchild);
		visit2(root);
		InThread(root->Rchild);
	}
}

/*
只有先序遍历会出现Lchild死循环,
因为只有visit()修改node空指针为pre之后,
之后又递归左子树,才会造成死循环
*/
void PreThread(Threadtree root) {
	if (root != NULL) {
		visit2(root);//在访问root时,如果当前节点的左指针指向pre,然后后面先序遍历又不断访问左子树,造成死循环
		//因此,判断当前节点的左指针是线索还是真正的指针
		if (root->Ltag == 0) {//只有真正的指针才访问左子树 
			PreThread(root->Lchild);
		}
		PreThread(root->Rchild);
	}
}


//中序线索二叉树遍历,利用线索实现非递归算法
//不需要调用辅助递归,空间复杂度O(1)
void InorderThread(ThreadNode* first) {
	for (ThreadNode* node = FirstInOrderNode(first);node != NULL;node = FindNextNode_InOrder(node)) {
		cout << node->data << endl;
	}
}
//中序二叉树逆序遍历
void RevInorderThread(ThreadNode* last) {
	for (ThreadNode* node = LastInOrderNode(last);node != NULL;node = FindPreNode_InOrder(node)) {
		cout << node->data << endl;
	}
}


//访问节点
void visit1(BiTNode* node) {
	if (node == target1) {//当前访问节点刚好是节点target
		res1 = pre1;//找到target的前驱
	} else {
		pre1 = node;//pre指向当前节点
	}
}
void visit2(ThreadNode* node) {
	if (node->Lchild == NULL) {//如果当前节点的左孩子空,建立前驱线索
		node->Lchild = pre2;
		node->Ltag = 1;
	}
	if (pre2 != NULL && pre2->Rchild == NULL) {//如果前驱节点不为空,前驱节点的右孩子为空
		pre2->Rchild = node;
		pre2->Rtag = 1;
	}
	pre2 = node;//往后遍历
}

void CreateInThread(Threadtree root) {
	pre2 = NULL;//初始化为NULL
	if (root != NULL) {//非空
		InThread(root);//中序线索化二叉树

		if (pre2->Rchild == NULL) {
			pre2->Rtag = 1;//线索化最后一个结点
		}
	}
}





//找到node中序遍历的节点
ThreadNode* FirstInOrderNode(ThreadNode* node) {
	//循环到最左下节点
	while (node->Ltag == 0) {
		node = node->Lchild;
	}
	return node;
}
//找到node中序遍历的节点
ThreadNode* LastInOrderNode(ThreadNode* node) {
	//循环最右下节点
	while (node->Rtag == 0) {
		node = node->Rchild;
	}
	return node;
}
//找到node的后继节点
ThreadNode* FindNextNode_InOrder(ThreadNode* node) {
	//右子树最左下节点
	if (node->Rtag == 0) {
		return FirstInOrderNode(node->Rchild);
	} else {
		return node->Rchild;//Rtag为1,直接返回后继线索
	}
}
//找到node的前驱节点
ThreadNode* FindPreNode_InOrder(ThreadNode* node) {
	//左子树最右下节点
	if (node->Ltag == 0) {
		return LastInOrderNode(node->Lchild);
	} else {
		return node->Lchild;
	}
}



//先序线索二叉树找先序后继
ThreadNode* FindNextNode_PreOrder(ThreadNode* node) {
	//左右子树就是第一个访问的节点
	if (node->Rtag == 0) {
		return node->Lchild == NULL ? node->Rchild : node->Lchild;
	} else {
		return node->Rchild;
	}
}
//先序线索二叉树找先序前驱
ThreadNode* FindPreNode_PreOrder(ThreadNode* node) {
	//左右子树只可能是孩子节点
	if (node->Ltag == 1) {
		return node->Lchild;
	} else {
		//这里要么原始方法,从头开始遍历.要么三叉树,记录node的父节点
		ThreadNode* patent;
		//1.node是parent的左孩子,,return parent;
		//2.node是parent的右孩子,,并且parent左孩子为空,,return parent;
		//3.node是parent的右孩子,,并且parent左孩子为空,,return 左子树先序遍历最后一个节点
		//4.node是根节点,return NULL;
	}
}






//后序线索二叉树的后序前驱
ThreadNode* FindPreNode_PostOrder(ThreadNode* node) {
	if (node->Ltag == 1) {
		return node->Lchild;
	} else {
		//1.node有右孩子,,前驱应该是右孩子后序遍历最后一个节点(也就是右孩子本身作为根节点),,return node->Rchild
		if (node->Rchild != NULL) {
			return node->Rchild;
		}
		//2.node无右孩子,,前驱应该是左孩子后序遍历最后一个节点(也就是左孩子本身作为根节点),,return node->Lchild
		if (node->Rchild == NULL) {
			return node->Lchild;
		}
	}
}
//后序线索二叉树的后序后继
ThreadNode* FindNextNode_PostInOrder(ThreadNode* node) {
	if (node->Rtag == 1) {
		return node->Rchild;
	} else {
		ThreadNode* parent;
		//1.node是parent的右孩子,,node的后继应该是parent,,return parent
		//2.node的parent的左孩子,,而且parent无右孩子,,return parent
		//3.node是parent的左孩子,,而且parent有右孩子,,return FirstPostNode(parent->right)
		//4.node无parent,,return NULL
	}
}