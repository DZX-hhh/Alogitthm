#include<bits/stdc++.h>
using namespace std;

/* 建立大根堆 */
void BuildMaxHeap(int A[], int n) {
	for (int i = n / 2;i > 0;--i) {
		Adjust(A, n, i);//从后往前调整所有非终端节点i
	}
}

/* 将以 i 为根节点的子树 调整 为大根堆 */
void Adjust(int A[], int n, int root) {
	A[0] = A[root];//暂存i为根节点
	for (int bigger = root * 2; bigger <= n; bigger *= 2) {//bigger指向左孩子
		if (bigger < n && A[bigger] < A[bigger + 1]) {//bigger<n为了确保A[bigger]有右兄弟,,并且左孩子小于右孩子的情况,bigger指向更大的那一个
			++bigger;
		}
		/* 开始调整 */
		if (A[0] > A[bigger]) {
			break;//当根节点大于左右子树的最大值,,调整结束
		} else {
			A[root] = A[bigger];//将"更大的节点调整到上面"
			root = bigger;//让根节点修改到当前更大的位置
		}
	}
	A[root] = A[0];//将以root的值放在最终root的位置
}

/* 堆排序 */
void HeapSort(int A[], int n) {
	BuildMaxHeap(A, n);//初始化建堆
	for (int i = n;i >= 2;--i) {//n-1趟的交换和建立堆的过程
		swap(A[i], A[1]);//不断让堆顶元素和堆底元素交换
		Adjust(A, n - 1, 1);//n-1,把剩余的待排序元素整理成堆
		/* 依次顺序得到升序序列 */
	}
}