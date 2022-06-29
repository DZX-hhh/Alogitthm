#include<bits/stdc++.h>
using namespace std;

typedef int ElemType;

/* 索引表 */
typedef struct {
	ElemType maxValue;//区间最大值
	int start, end;//区间范围
}Index;

/* 顺序表存储实际元素 */
ElemType List[100];