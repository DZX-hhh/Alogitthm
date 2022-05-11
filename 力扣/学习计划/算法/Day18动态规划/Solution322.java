package 力扣.学习计划.算法.Day18动态规划;

import java.util.Arrays;

public class Solution322 {
    /**
     * 典型的完全01背包问题,求组合
     * 外for物品内for背包,正序遍历
     *
     * @param coins  -->物品
     * @param amount -->背包容量
     * @return dp[amount]:容量为amount的背包可以拿的最少硬币的数量
     * dp[i]=min(dp[i],dp[i-num[j]]+1)
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                if (dp[j - coins[i]] != Integer.MAX_VALUE) {//说明dp[j-coins[i]]是初始值,则跳过
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
