package LeetCode.学习计划.算法.Day18动态规划;

public class Solution343 {
    /*
        dp[n]:整数n拆分成k个正整数的最大乘积
        dp[i]=max(dp[i],(i-j)*j,dp[i-j]*j)//含义:不拆分,拆分成(i-j)和j两部分,拆分成3部分
     */
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max((i - j) * j, dp[i - j] * j));
            }
        }
        return dp[n];
    }
}
