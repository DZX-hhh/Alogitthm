package LeetCode.学习计划.算法.Day12动态规划;

public class Solution198 {
    /**
     * 递推式: dp[i]=Math.max(dp[i-1],(dp[i-2]+nums[i]))
     * 含义:当天最大值==max(当天偷的+前天偷的最大值,昨天偷的最大值)
     */
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[dp.length - 1];
    }
}
