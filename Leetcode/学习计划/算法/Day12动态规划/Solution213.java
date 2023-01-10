package LeetCode.学习计划.算法.Day12动态规划;

import java.util.Arrays;

public class Solution213 {
    /**
     * 环形-->两个线性列表
     * 一个忽略头部,一个忽略尾部
     * dp[i]
     */
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(myRob(Arrays.copyOfRange(nums, 1, nums.length)), myRob(Arrays.copyOfRange(nums, 0, nums.length - 1)));
    }

    private int myRob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
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
