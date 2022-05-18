#### [剑指 Offer 13. 机器人的运动范围](https://leetcode.cn/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/)

难度中等496收藏分享切换为英文接收动态反馈

地上有一个m行n列的方格，从坐标 `[0,0]` 到坐标 `[m-1,n-1]` 。一个机器人从坐标 `[0, 0] `
的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]
，因为3+5+3+8=19。请问该机器人能够到达多少个格子？

**示例 1：**

```
输入：m = 2, n = 3, k = 1
输出：3
```

**示例 2：**

```
输入：m = 3, n = 1, k = 0
输出：1
```

**提示：**

- `1 <= n,m <= 100`
- `0 <= k <= 20`

```java
public class Solution13 {
    public int movingCount(int m, int n, int k) {
        boolean[][] isValid = new boolean[m][n];
        return dfs(m, n, 0, 0, k, isValid);
    }

    private int dfs(int m, int n, int r, int c, int k, boolean[][] isValid) {
        //1.超过边界,返回0
        if (r >= m || c >= n || r < 0 || c < 0) {
            return 0;
        }
        //2.位和大于k,返回0
        if ((r % 10 + r / 10 + c % 10 + c / 10) > k) {
            return 0;
        }
        //3.已经访问过,返回0
        if (isValid[r][c]) {
            return 0;
        }
        //4.开始选择
        isValid[r][c] = true;
        //5.递归
        return dfs(m, n, r - 1, c, k, isValid) +
                dfs(m, n, r + 1, c, k, isValid) +
                dfs(m, n, r, c - 1, k, isValid) +
                dfs(m, n, r, c + 1, k, isValid) + 1;

        /*
            这里不需要回溯,撤销选择,因为这里是标记某个点能否通过,能通过就true,反之false
         */
    }
}
```