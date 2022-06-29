#include<bits/stdc++.h>
using namespace std;

typedef int ElemType;

/* 查找表的结构(顺序表) */
typedef struct {
	ElemType* arr;//动态数组基址
	int Tablelen;//表的长度
}SSTable;

/* 顺序查找 */
int Search_Seq(SSTable ST, ElemType value) {
	int index;
	for (index = 0; index < ST.Tablelen && ST.arr[index] != value; ++index) {
		//continue;
	}
	//查找成功返回index,失败返回index
	return index == ST.Tablelen ? -1 : index;
}
//改进:无需判断是否越界,,效率更高
int Search_Seq2(SSTable ST, ElemType value) {
	ST.arr[0] = value;//哨兵
	int index;
	for (int index = ST.Tablelen; ST.arr[index] != value;--index) {
		//continue;
	}
	return index;
}