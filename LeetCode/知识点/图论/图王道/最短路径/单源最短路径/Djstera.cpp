#include<bits/stdc++.h>
using namespace std;

#define N 5

bool final[N];//标记各顶点是否找到最短路径
int dis[N];//最短路径的长度
int path[N];//路径前驱

/* 迪杰斯特拉算法思路O(n²)*/
//1.初始化数组
void Djstra() {
	final[0] = true;//设置自己的最短路径已找到
	dis[0] = 0;//路径长度为0
	path[0] = -1;//无前驱

	//2.其余顶点:final[k]=false,dis[k]=acrs[0][k],path[k]=(acrs[0][k]==无穷)?-1:0;

	//3.n-1轮处理:遍历其他所有顶点,找到fianl[i]为false并且dis[i]的min值Vi:令final[i]=true

	//4.检查Vi的所有邻接点Vj,如果final[j]=false && dis[i]+acrs[i][j] < dis[j]
	//  则更新dis[j]=dis[i]+acrs[i][j];
	//  path[j]=i;
}

//-----缺点:不适合用于负权值带权图------------------