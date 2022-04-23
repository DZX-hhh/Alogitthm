#### [剑指 Offer 47. 礼物的最大价值](https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/)

难度中等281

在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于
0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？

**示例 1:**

```
输入: 
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
输出: 12
解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
```

提示：

- `0 < grid.length <= 200`
- `0 < grid[0].length <= 200`

**动态规划**

```java
public class T2 {
    /**
     * @param grid
     * @return 动态规划
     */
    public int maxValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];//记录到当前的位置的最大值

        //初始化数据
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) dp[i][0] = dp[i - 1][0] + grid[i][0];
        for (int j = 1; j < n; j++) dp[0][j] = dp[0][j - 1] + grid[0][j];

        //当前位置的最大值dp[row][col]=Math.max(dp[row-1][col]+g[row][col],dp[row][col-1]+g[row][col])
        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col++) {
                dp[row][col] = Math.max(dp[row - 1][col] + grid[row][col], dp[row][col - 1] + grid[row][col]);
            }
        }
        return dp[m - 1][n - 1];
    }
}
```