#include <bits/stdc++.h>
using namespace std;

typedef struct TreeNode {
	int val;
	struct TreeNode* children;
}TreeNode, * Tree;

//访问根节点
void visit1(TreeNode* root) {
	cout << root->val << endl;
}

// 树的先根遍历
void PreOrder(Tree root) {
	if (root != NULL) {
		visit1(root);//访问根节点
		while (root->children != NULL) {
			//这些节点必然是没访问过的,但是图依然需要isVisited数组记录是否访问
			PreOrder(root->children);
		}
	}
}

/* ---------------------------------------------- */

#define max_vertex_num 100
bool Isvisited[max_vertex_num];//标记访问数组

typedef struct Graph {
	int vernum;
}Graph;

void visit2(int V) {
	cout << V << endl;
}

//第一个邻接点
int FirstNeighbor(Graph G, int V) {};

//下一个临界点
int NextNeighbor(Graph G, int V, int next) {};

void DFS(Graph G, int V) {
	visit2(V);//访问
	Isvisited[V] = true;//记录访问

	//依次访问邻接点
	for (int next = FirstNeighbor(G, V); next >= 0; next = NextNeighbor(G, V, next)) {
		if (!Isvisited[next]) {//若未访问,开始DFS
			DFS(G, next);//递归next节点
		}
	}
}


/* 解决非连通图无法依次DFS就访问所有节点 */
void DFSraverse(Graph G) {
	for (int i = 0; i < G.vernum; i++) {
		Isvisited[i] = false;
	}
	for (int i = 0; i < G.vernum; i++) {
		if (!Isvisited[i]) {
			DFS(G, i);//如果未访问过,就再来一次DFS
		}
	}
}


/*
->邻接矩阵<-

空间复杂度:
	最主要来自于dfs函数递归调用:
		最坏情况:递归深度O(n)
		最好情况:递归深度O(1)

时间复杂度:等于访问各节点的时间+探索每条边的所需时间
时间复杂度:O(n²)
	访问各节点的时间O(n)
	探索每条表的时间O(n²)
*/

/*
->邻接表<-

空间复杂度:
	最主要来自于dfs函数递归调用:
			最坏情况:递归深度O(n)
			最好情况:递归深度O(1)

时间复杂度:等于访问各节点的时间+探索每条边的所需时间
时间复杂度:O(n+|E|)
	访问节点:O(n)
	访问边:O(|E|)
*/