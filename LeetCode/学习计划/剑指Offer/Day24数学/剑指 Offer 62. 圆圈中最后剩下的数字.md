#### [剑指 Offer 62. 圆圈中最后剩下的数字](https://leetcode.cn/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/)

难度简单604收藏分享切换为英文接收动态反馈

0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。求出这个圆圈里剩下的最后一个数字。

例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。

**示例 1：**

```
输入: n = 5, m = 3
输出: 3
```

**示例 2：**

```
输入: n = 10, m = 17
输出: 2
```

**限制：**

- `1 <= n <= 10^5`
- `1 <= m <= 10^6`

**队列模拟**

> 这里使用`ArrayList`而不使用`linkedList`

```java
/*
    队列模拟
 */
public int lastRemaining(int n, int m) {
    ArrayList<Integer> queue = new ArrayList<>();
    for (int i = 0; i < n; i++) {
        queue.add(i);
    }
    int idx = 0;
    while (n > 1) {
        idx = (idx + m - 1) % n;//这里循环模拟,删除往后第m个元素%n
        queue.remove(idx);
        n--;
    }
    return queue.get(0);
}
```

**约瑟夫环**

```java
    /*
        约瑟夫环
     */
public int lastRemaining2(int n,int m){
        if(n<=1){
        return 0;
        }
        int res=(lastRemaining(n-1,m)+m)%n;
        return res;
        }
```