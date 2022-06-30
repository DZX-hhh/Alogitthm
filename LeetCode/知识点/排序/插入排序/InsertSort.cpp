#include <bits/stdc++.h>
using namespace std;

void InsertSort(int A[], int n) {
	int i, j, temp;
	for (i = 1; i < n; ++i) {
		//第一个元素默认已经排好将各元素插入到已经排好序的序列中
		if (A[i] < A[i - 1]) {//当前关键字小于前驱,,要插在前面
			temp = A[i];//temp暂存A[i]
			for (j = i - 1; j >= 0 && A[j] > temp; --j) {//检查前面已经拍好序的元素
				A[j + 1] = A[j];//后移
			}
			A[j + 1] = temp;//插入
		}
	}
}

/* 带哨兵版,,避免每次都判断j>=0的问题 */
void InsertSort_WithSoldier(int A[], int n) {
	for (int i = 2; i <= n; i++) {
		if (A[i] < A[i - 1]) {
			A[0] = A[i];
			int j = i - 1;
			for (; j >= 0 && A[0] < A[j]; j--) {
				A[j + 1] = A[j];
			}
			A[j + 1] = A[0];
		}
	}
}

// 空间复杂度:O(1)

// 时间复杂度:
//		最好情况:n-1躺处理,,每一趟都只需要对比关键字1次,不需要移动元素----O(n)
//      最坏情况:n-1躺处理,,原本都是逆序,,第i-1躺需要对比关键字i次,,移动关键字i+1次----O(n²)
//      平均情况:O(n²)

//		稳定


/*
优化:线性扫描为二分查找
为了保证算法的稳定性:::这里寻找小于A[0](哨兵)的最大值(右边界)

时间复杂度:二分对比线性查找只是减少的比较关键字的次数,,但是移动元素的次数没变,,依然是O(n²)
*/
void InsertSort_WithSoldier_BinarySearch(int A[], int n) {
	for (int i = 2; i <= n; i++) {//默认第一个位子不用管
		if (A[i] < A[i - 1]) {
			A[0] = A[i];//哨兵暂存当前元素
			/* 这里二分查找替换线性查找 */
			int index = BinarySearch(A, n);
			int j = i - 1;
			for (; j >= index; j--) {
				A[j + 1] = A[j];
			}
			A[index] = A[0];//填充查找到的要替换的位置
		}
	}
}
/* 求小于A[0]的最大值(右边界) */
int BinarySearch(int A[], int n) {
	int low = 1, high = n;//左右变量
	while (low <= high) {
		int mid = low + (high - low) / 2;
		/* 求右边界 */
		if (A[mid] == A[0]) {
			low = mid + 1;
		} else if (A[mid] < A[0]) {
			low = mid + 1;
		} else if (A[mid] > A[0]) {
			high = mid - 1;
		}
	}
	return low;
}