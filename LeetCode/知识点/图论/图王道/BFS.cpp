#include<bits/stdc++.h>
using namespace std;

#define MAX_VERTEX_NUM 100

struct Graph {
	int vexNum;
};//图结构

queue<int> Queue;//辅助队列
bool Isvisited[MAX_VERTEX_NUM];//标记访问数组

void visit(int V) {};//访问节点V

//第一个邻接点
int FirstNeighbor(Graph G, int V) {};
//下一个临界点
int NextNeighbor(Graph G, int V, int first) {};


/* 从顶点V出发,广度遍历图G,先将V的各临界点入队,再重复 */
void BFS(Graph G, int V) {
	visit(V);//访问初始节点V
	Isvisited[V] = true;//访问标记
	Queue.push(V);//顶点V入辅助队列Queue

	while (!Queue.empty()) {
		int V = Queue.front();
		Queue.pop();//顶点V出队

		//依次访问邻接点
		for (int next = FirstNeighbor(G, V);next >= 0;next = NextNeighbor(G, V, next)) {
			//检测V的所有邻接点
			if (!Isvisited[next]) {//当前节点未访问过
				visit(next);//访问当前节点
				Isvisited[next] = true;//记录标记
				Queue.push(next);//下一个临界点入队
			}
		}
	}
}


/*
	缺点:如果是非连通图,,只用一个BFS函数无法遍历所有节点
	每一个连通分量都调用一次BFS,如果V未访问,则开始BFS
*/
void BSTraverse(Graph G) {
	for (int i = 0; i < G.vexNum; i++) {
		Isvisited[i] = false;//初始化都未访问
	}
	for (int i = 0; i < G.vexNum; i++) {
		if (!Isvisited[i]) {
			BFS(G, i);//i未访问,开始BFS
		}
	}
}



/*
->邻接矩阵<-

空间复杂度:O(n)
	主要来自辅组队列,,取决于某个点临界点的个数

时间复杂度:等于访问各节点的时间+探索每条边的所需时间
时间复杂度:O(n²)
	访问每个节点的时间O(n)
	查找每个顶点的邻接点O(n),,n个顶点则是n²
*/


/*
->邻接表<-

空间复杂度:同为辅助队列大小:O(n)

时间复杂度:等于访问各节点的时间+探索每条边的所需时间
时间复杂度:O(n+|E|)
	访问n个节点O(n)
	查找各个顶点的邻接点O(|E|)
*/

// 应用:单源最短路径