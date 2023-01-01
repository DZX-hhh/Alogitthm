#include<bits/stdc++.h>
using namespace std;

/* 快排 */
void QuickSort(int A[], int low, int high) {
	if (low < high) {//递归跳出的条件,,low和high都指向pivot
		int pivot = Partition(A, low, high);//划分左小右大
		QuickSort(A, low, pivot - 1);//划分左子表
		QuickSort(A, pivot + 1, high);//划分右子表
	}
}

/* 划分左小右大 O(n) */
int Partition(int A[], int low, int high) {
	int pivot = A[low];//选取第一个元素作为基准
	while (low < high) {
		while (low < high && A[high] >= pivot) high--;
		A[low] = A[high];//找到比pivot更小的元素,,放在左边,也就是low上
		while (low < high && A[low] <= pivot) low++;
		A[high] = A[low];//找到比pivot大的元素,,放在右边,,也就是high上
	}
	A[low] = pivot;//基准元素放到最终的位置
	return low;//返回最终位置
}

/* 随机数确认pivot的位置 */
int Partition(int A[], int low, int high) {
	int rindex = (rand() % (high - low + 1)) + low;//生成[a,b]的随机整数
	swap(A[rindex], A[high]);//为了避免有序的情况,,将基准元素放在最右边
	int index = low;//最终返回的基准位置
	for (int j = low; j <= high - 1; j++) {
		if (A[j] <= A[high]) {//将比pivot小的元素放在左边,,其余的都比pivot大
			swap(A[j], A[index]);
			index++;
		}
	}
	swap(A[index], A[high]);
	return index;
}

void swap(int& a, int& b) {
	int t = a;
	a = b;
	b = t;
}
