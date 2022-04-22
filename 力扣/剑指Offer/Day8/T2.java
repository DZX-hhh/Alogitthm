package 力扣.剑指Offer.Day8;

public class T2 {
    /*动态规划,,维护备忘录*/
    int mod = 1000000007;

    public int numWays(int n) {
        if (n <= 1) return 1;
        //备忘录
        int[] dp = new int[n + 1];
        //初始化
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            //第i层的跳法=第i-1层跳一级台阶+第i-2层跳两级台阶
            dp[i] = (dp[i - 1] + dp[i - 2]) % mod;
        }
        return dp[n];
    }
}
