#include <bits/stdc++.h>
using namespace std;
#define maxsize 255

typedef struct {
  char ch[maxsize];
  int length;
} SString;

/*
求模式串T的next数组
本质上next[from]=(1~from-1)串前缀和后缀的最长长度+1

存在的问题:多进行了一次无意义的对比
*/
void get_next(SString T, int next[]) {
  int from = 1, to = 0;
  next[from] = to;  // next[1] = 0;

  while (from < T.length) {
    if (to == 0 || T.ch[from] == T.ch[to]) {
      ++from, ++to;
      //若p[from]=p[to],next[from+1]=next[from]+1
      next[from] = to;  //设置next值
    } else {
      //否则,让to=next[to],循环继续
      to = next[to];
    }
  }
}

/*
优化next数组,直接跳过重复的不匹配
*/
void get_nextval(SString T, int next[]) {
  //先得到next数组
  int from = 1, to = 0;
  next[from] = to;
  while (from < T.length) {
    if (to == 0 || T.ch[from] == T.ch[to]) {
      ++from, ++to;
      next[from] = to;  // from跳转到to的位置
    } else {
      to = next[to];
    }
  }
  // nextval数组优化next数组
  int nextval[T.length + 1];
  nextval[1] = 0;
  for (int from = 2; from < T.length; from++) {
    if (T.ch[from] == T.ch[next[from]]) {
      //出现跳转之后的位置还是相等,依然会不匹配
      nextval[from] = nextval[next[from]];  //直接跳转到第一个可以匹配的位置
    } else {
      nextval[from] = next[from];
    }
  }
}
/*
O(m+n)
*/
int Index_KMP(SString S, SString T) {
  int i = 1, j = 1;  // i为总串的下标,j为模式串的下标
  int next[T.length + 1];
  /* 求模式串的next数组 */
  get_next(T, next);                        // O(m)
  while (i <= S.length && j <= T.length) {  // O(n)
    if (j == 0 || S.ch[i] == T.ch[j]) {
      ++i, ++j;  //继续比较后继字符
    } else {
      j = next[j];  //模式串向右移动
    }

    if (j > T.length) {
      return i - T.length;  //匹配到达尽头,成功!
    } else {
      return 0;
    }
  }
}