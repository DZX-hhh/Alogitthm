#include <bits/stdc++.h>
using namespace std;

typedef int ElemType;//元素类型

/* 针对有序数对 */
typedef struct {
	ElemType* arr;//动态数组
	int TabLen;//表的长度
}SSTable;

//二分查找
int Binare_Search(SSTable ST, ElemType value) {
	int low = 0, high = ST.TabLen - 1;
	while (low <= high) {
		int mid = (low + high) / 2;//中间位置
		if (ST.arr[mid] == value) {//查找成功
			return mid;
		} else if (ST.arr[mid] > value) {
			high = mid - 1;
		} else {
			low = mid + 1;
		}
	}
	return -1;
}

/* 查找效率:O(log₂n) */