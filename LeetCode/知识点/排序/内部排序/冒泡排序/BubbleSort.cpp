#include<bits/stdc++.h>
using namespace std;

/* 将最小的数冒泡到最前 */
void BubbleSort_Small(int A[], int n) {
	for (int i = 0; i < n - 1; i++) {//需要冒泡n-1个数,,也就是n-1次
		bool flag = false;
		for (int j = n - 1; j > i; j--) {//将最小的数冒泡到最前
			if (A[j] < A[j - 1]) {
				swap(A[j], A[j - 1]);//交换
				flag = true;
			}
		}
		//发生冒泡的标记,,如果为false,,那么说明已经有序
		if (!flag) {
			return;
		}
	}
}
/* 最大的数冒泡到最后 */
void BubbleSort_Big(int A[], int n) {
	for (int i = 0; i < n - 1; i++) {
		bool flag = false;
		for (int j = 0; j < n - i - 1; j++) {//这里冒泡将最大的数冒泡到最后
			if (A[j] < A[j + 1]) {
				swap(A[j], A[j + 1]);
				flag = true;
			}
		}
		if (!flag) {
			return;
		}
	}
}

/* 交换 */
void swap(int& a, int& b) {
	int t = a;
	a = b;
	b = t;
}