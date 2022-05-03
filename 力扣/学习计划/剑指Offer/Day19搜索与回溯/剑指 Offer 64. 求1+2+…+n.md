#### [剑指 Offer 64. 求1+2+…+n](https://leetcode.cn/problems/qiu-12n-lcof/)

难度中等492收藏分享切换为英文接收动态反馈

求 `1+2+...+n` ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。

**示例 1：**

```
输入: n = 3
输出: 6
```

**示例 2：**

```
输入: n = 9
输出: 45
```

**限制：**

- `1 <= n <= 10000`

> 巧妙运用短路与`&&`  也就是`if()`的原理

```java
public class Solution64 {
    /**
     * 这里不使用条件判断的话,,可以使用 &&
     * a && function()
     * 当a为真的时候才执行function
     * 也就是if的原理
     */
    public int sumNums(int n) {
        int sum = n;
        boolean flag = (n > 0) && ((sum += sumNums(n - 1)) > 0);
        return sum;
    }
}
```