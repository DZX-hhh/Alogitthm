#include<bits/stdc++.h>
using namespace std;

#define MaxVertexNum 100


typedef int VertexType;//顶点类型
typedef int Edge;//带权边的类型

//--等同于树的孩子表示法

/* 顶点 */
typedef struct VNode {
	VertexType data;//顶点信息
	Edge* firstedge;//第一条边/弧
}VNode, AdjList[MaxVertexNum];

/* "边/弧" */
typedef struct Edge {
	int targetNode;//边/弧指向那个节点
	struct Edge* next;//指向下一条弧的指针
	//InfoType info; //边权值
}Edge;

/* 邻接表存储图 */
typedef struct {
	AdjList vertices;
	int nodes, edges;
}ALGraph;

//-------------
// 空间复杂度:
//			有向图:边节点的数量|E|,整体空间复杂度为O(|V|+|E|)
//			无向图:边节点的数量2|E|,整体空间复杂度为O(|V|+2|E|):因为一条边会用到两次



//讨论节点的度: 
//			有向图:遍历节点,计数边的数量即为当前节点度
//			有向图:遍历节点,计数边的数量即为当前节点"出"度
//-----