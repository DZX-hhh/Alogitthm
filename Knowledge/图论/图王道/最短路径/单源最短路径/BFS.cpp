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



//记录距离
int dis[MAX_VERTEX_NUM];

//记录前驱
int OnPath[MAX_VERTEX_NUM];

//BFS求顶点V到其他顶点的最短路径
void BFS_MIN_Distance(Graph G, int V) {
	//dis[i]表示V到i节点的最短路径
	for (int i = 0; i < G.vexNum; i++) {
		dis[i] = INT_MAX;//初始化路径距离
		OnPath[i] = -1;//最短路径从哪一个顶点过来
	}

	dis[V] = 0;//自己到自己的距离为0
	Isvisited[V] = true;//开始访问
	Queue.push(V);//入队
	while (!Queue.empty()) {
		int V = Queue.front();
		Queue.pop();//顶点V出队

		//依次访问邻接点
		for (int next = FirstNeighbor(G, V);next >= 0;next = NextNeighbor(G, V, next)) {
			//检测V的所有邻接点
			if (!Isvisited[next]) {//当前节点未访问过

				dis[next] = dis[V] + 1;//路径长度+1
				OnPath[next] = V;//记录next的前驱节点V:也就是V->next

				Isvisited[next] = true;//记录标记
				Queue.push(next);//下一个临界点入队
			}
		}
	}
}


/*局限性:只能用于无权图,如果是带权图,需要用Djstera算法*/