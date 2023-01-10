package LeetCode.学习计划.算法.Day15动态规划;

public class Solution58 {
    /**
     * 完全01背包
     * dp[j]+=dp[j-coins[i]]
     *
     * @param amount -->背包
     * @param coins  -->物品
     * @return dp[amount]:总金额的组合数
     */
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int j = 0; j < coins.length; j++) {//外for物品
            for (int i = coins[j]; i <= amount; i++) {//内for背包
                dp[i] += dp[i - coins[j]];
            }
        }
        return dp[amount];
    }
}
