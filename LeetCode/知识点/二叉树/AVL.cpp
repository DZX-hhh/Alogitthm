#include<bits/stdc++.h>
using namespace std;
/*
平衡二叉树 AVL

定义:任意节点的左子树和右子树的高度差<=1

平衡因子:左子树高-右子树高
		平衡二叉树的平衡因子只可能是-1,0,1
*/


//平衡二叉树节点
typedef struct AVLNode {
	int val; //数据域
	int balance; //平衡因子
	struct AVLNode* Lchild, * Rchild;
}AVLNode, * AVLTree;



//`BST`插入新节点,如何保持平衡?
//"最小不平衡子树" :插入点往回找到第一个不平衡节点,以此节点为根的子树

/* 如何调整最小不平衡子树 */
//1.root的左孩子的左子树插入导致不平衡 --LL  -->一级右旋(变爹)
//2.root的右孩子的右子树插入导致不平衡 --RR  -->一级左旋(变爹)
//3.root的左孩子的右子树插入导致不平衡 --LR  -->二级左旋后再右旋(变爷)
//4.root的右孩子的左子树插入导致不平衡 --RL  -->二级右旋后再左旋(变爷)
//-------需要画图理解  旋转节点的操作
//实现f向右下旋转,p向右上旋转----其中f是爹,p是左孩子,gf是f爹
/*
	AVLNode* p, * f, * gf;
	f->Lchild = p->Rchild;//p右孩子移动到f的左孩子
	p->Rchild = f;//p往右移动
	gf->Lchild / Rchild = p;//p往上移动
*/






/*
查找效率:树高为h,,最坏情况:O(n) 即查找时间复杂度不可能超过O(h)

AVL 深度为h,n(h)表示此深度最少节点数
	n(0)=0, n(1)=1, n(2)=2
	n(h)=根节点+左子树+右子树
		=1 + n(h-1) + n(h-2)
		=> n个节点的AVL的最大深度为O(log₂n)
		=> AVL平均查找长度为O(log₂n)
*/

