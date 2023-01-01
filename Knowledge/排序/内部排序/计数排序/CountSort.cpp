#include<bits/stdc++.h>
using namespace std;

/*  计数排序
	计数整个数组中小于某元素的个数cnt,并放在另一个数组的cnt位置上
	相比于插入排序:相比于选择排序,比较次数更多,并且额外空间
*/
void CountSort(int a[], int b[], int n) {
	int cnt = 0;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (a[j] < a[i]) {
				cnt++;
			}
		}
		b[cnt] = a[i];
	}
}