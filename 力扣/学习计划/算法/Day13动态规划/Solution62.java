package 力扣.学习计划.算法.Day13动态规划;

public class Solution62 {
    //    dp[r][c]=dp[r-1][c]+dp[r][c-1]
    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        int[][] dp = new int[m][n];
        //1.初始化dp
        for (int r = 0; r < m; r++) {
            dp[r][0] = 1;
        }
        for (int c = 0; c < n; c++) {
            dp[0][c] = 1;
        }
        //2.开始循环
        for (int r = 1; r < m; r++) {
            for (int c = 1; c < n; c++) {
                //递推方程
                dp[r][c] = dp[r - 1][c] + dp[r][c - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    //排列组合问题,C m+n-2 (m-1) 这个是概率
    // 1/概率为选择个数
    public int uniquePaths2(int m, int n) {
        long res = 1;
        for (int i = 0; i < Math.min(m - 1, n - 1); i++) {
            res *= m + n - 2 - i;//这里逆着乘到m-1
            res /= i + 1;//这里顺着乘到min(m-1,n-1)
        }
        return (int) res;
    }
}
