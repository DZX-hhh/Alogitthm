#### [剑指 Offer 66. 构建乘积数组](https://leetcode.cn/problems/gou-jian-cheng-ji-shu-zu-lcof/)

难度中等226

给定一个数组 `A[0,1,…,n-1]`，请构建一个数组 `B[0,1,…,n-1]`，其中 `B[i]` 的值是数组 `A` 中除了下标 `i` 以外的元素的积,
即 `B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]`。不能使用除法。

**示例:**

```
输入: [1,2,3,4,5]
输出: [120,60,40,30,24]
```

**提示：**

- 所有元素乘积之和不会溢出 32 位整数
- `a.length <= 100000`

**两次循环**

```java
public class Solution66 {
    /*
        两次循环:第一次计算i左边的乘积
                第二次计算i右边的乘积
                [a,b,c,d,e]
             -->res = [1, a, ab, abc, abcd]
             -->res = [bcde, acde, abde, abce, abcd]
     */
    public int[] constructArr(int[] a) {
        int[] res = new int[a.length];
        int multi = 1;
        for (int i = 0; i < a.length; i++) {//第一趟构造i左边的乘积
            res[i] = multi;
            multi *= a[i];
        }
        multi = 1;
        for (int i = a.length - 1; i >= 0; i--) {//第二次构造i右边的乘积
            res[i] *= multi;//这里不能像左边一样,因为左边已经有乘积了
            multi *= a[i];
        }
        return res;
    }
}
```