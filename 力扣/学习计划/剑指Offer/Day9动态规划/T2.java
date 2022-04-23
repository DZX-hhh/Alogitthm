package 力扣.学习计划.剑指Offer.Day9动态规划;

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
