#### [剑指 Offer 49. 丑数](https://leetcode.cn/problems/chou-shu-lcof/)

难度中等341

我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。

**示例:**

```
输入: n = 10
输出: 12
解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
```

**说明:**

1. `1` 是丑数。
2. `n` **不超过**1690。

注意：本题与主站 264 题相同：https://leetcode-cn.com/problems/ugly-number-ii/

#### 思路

> 动态规划
> 大丑数可由由小丑数*2,*3,*5的最小值得到

#### Code

```java
public class Solution49 {
    /**
     * 大丑数由小丑数*2,*3,*5的最小值得到
     */
    public int nthUglyNumber(int n) {
        int a = 0, b = 0, c = 0;
        int[] dp = new int[n];
        dp[0] = 1;//最开始第0位的丑数为1
        for (int i = 1; i <= n; i++) {
            int t2 = dp[a] * 2, t3 = dp[b] * 3, t5 = dp[c] * 5;
            dp[i] = Math.min(t2, Math.min(t3, t5));
            if (dp[i] == t2) {
                a++;
            }
            if (dp[i] == t3) {
                b++;
            }
            if (dp[i] == t5) {
                c++;
            }
        }
        return dp[n - 1];
    }
}
```