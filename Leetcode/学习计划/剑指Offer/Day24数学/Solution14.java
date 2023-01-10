package LeetCode.学习计划.剑指Offer.Day24数学;

public class Solution14 {
    /*
        动态规划dp[i],拆分数字i 的最大乘积
        dp[i]=max(dp[i], (i-j)*j, j*dp[i-j])
        意思是可以不拆分当前,也可以直接拆分成i-j和j两部分,,,也可以拆分成j和dp[i-j]等多部份
     */
    public int cuttingRope(int n) {
        if (n == 2) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i < n + 1; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max((i - j) * j, dp[i - j] * j));
            }
        }
        return dp[n];
    }
}
