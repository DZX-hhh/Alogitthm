#include <bits/stdc++.h>
using namespace std;

#define MaxVertexNum 100 //顶点项目的最大值
#define INFINITY INT_MAX //定义无s穷为int的最大值


typedef struct {
	char Vex[MaxVertexNum]; //顶点表
	bool Edge[MaxVertexNum][MaxVertexNum]; //邻接矩阵,边表:某行某列的元素是否邻接
	int vexs, edges;//图的当前顶点数和边数/弧数
}MGraph1;


/*
	空间复杂度为O(n²):只和邻接矩阵的定点数有关,,和实际边数无关
	比较适合存储稠密图
	无向图的邻接矩阵A 为对称矩阵,可采用上(下)三角矩阵压缩存储
	Aⁿ 的元素Aⁿ[i][j] = i->j 的长度为"n"的路径的数目
*/
typedef char VertexType;//顶点的类型
typedef int EdgeType;//边权值类型
typedef struct {
	VertexType Vex[MaxVertexNum];//顶点表
	EdgeType Edge[MaxVertexNum][MaxVertexNum];//边的权值表:为0表示顶点自身到自身没有边  为无穷时,表示不邻接
}MGraph2;
