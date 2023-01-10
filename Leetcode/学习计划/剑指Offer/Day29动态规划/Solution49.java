package LeetCode.学习计划.剑指Offer.Day29动态规划;

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
