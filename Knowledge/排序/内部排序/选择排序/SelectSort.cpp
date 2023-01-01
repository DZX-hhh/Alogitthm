#include<bits/stdc++.h>
using namespace std;

/* 简单选择排序 */
void SelectSort(int A[], int n) {
	for (int i = 0; i < n - 1; i++) {//一共n-1趟
		int min_index = i;//记录最下元素位置
		for (int j = i + 1; j < n; j++) {
			if (A[j] < A[min_index]) {
				min_index = j;//更新最小元素位置
			}
		}
		if (min_index != i) {
			swap(A[min_index], A[i]);//将选择的最小元素放到前面
		}
	}
}

void swap(int& a, int& b) {
	int t = a;
	a = b;
	b = t;
}