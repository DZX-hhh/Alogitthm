package 力扣.学习计划.算法.Day15动态规划;

public class Solution377 {
    /**
     * 01背包问题
     * 又因为可以多次拿num[]的物品,因此是完全背包
     * > 外for背包,内for物品-->排列数
     * > 内for背包,外for物品-->组合数
     * dp[i]:值为i,可以在num里面找到总和为i的个数
     * dp[i]+=dp[i-num[j]];
     * 含义:背包中和为i的个数等于和为i-num[j]加起来,因为nums[j]出先在数组中可以多次选择
     *
     * @param nums   -->物品
     * @param target -->背包
     * @return dp[target]
     */
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;//初始化,无实际意义
        for (int i = 0; i <= target; i++) {//背包
            for (int j = 0; j < nums.length; j++) {//物品
                if (i >= nums[j]) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }

    /*
        斐波那契数列
        递归版本
        f(n)=f(n-1)+f(n-2)
     */
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    /*
        动态规划
     */
    public int fib2(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
