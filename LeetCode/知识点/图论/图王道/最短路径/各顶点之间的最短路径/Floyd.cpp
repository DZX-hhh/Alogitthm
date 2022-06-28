#include <bits/stdc++.h>
using namespace std;

/*
	Flod算法:求出每一对顶点(i,j)之间的最短路径
	动态规划:观察Vk是否可以加入使得路径更短
//准备工作,根据图信息初始化邻接矩阵A和Path
for (int k = 0; k < n; k++) {//以"Vk"为中转点的路径更短
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (A[i][j] > A[i][k] + A[k][j]) {//以Vk为中转点的路径更短
				A[i][j] = A[i][k] + A[k][j];//更新最短路径长度
				OnPath[i][j] = k;//中转点
			}
		}
	}
}
*/

// 时间复杂度:O(n³):主要来自于三次循环n次的时间
// 空间复杂度:O(n²):主要来自于邻接矩阵的空间

// Flyod解决带负权值的图(图不能有环,这种图可能没有最短路径)