#include <bits/stdc++.h>
using namespace std;

#define maxsize 100
typedef int ElemType; //默认为整数

/*
二叉树顺序存储
由于可能出现全是右子树,但是又不得不用2ⁿ-1个空间
因此,只适用于存完全二叉树
*/
struct TreeNode {
    ElemType value; //节点的数据元素
    bool isEmpty; //节点是否为空
};

int main()
{
    TreeNode t[maxsize]; //层序存储节点
    for (int i = 0; i < maxsize; i++) {
        t[i].isEmpty = true;
    }
    return 0;
}
