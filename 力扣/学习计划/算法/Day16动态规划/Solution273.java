package 力扣.学习计划.算法.Day16动态规划;

import java.util.Arrays;

public class Solution273 {
    public int findNumberOfLIS(int[] nums) {
        int res = 0, maxCount = 0;
        int[] dp = new int[nums.length];//以`num[i]`结尾的最长子序列长度
        int[] count = new int[nums.length];//以`num[i]`结尾的最长子序列长度的个数
        //初始化长度和个数都为1
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {//说明可以放在nums[j]的后面
                    if (dp[j] + 1 > dp[i]) {//1.如果出现长度更大的子序列
                        dp[i] = dp[j] + 1;//更新长度
                        count[i] = count[j];//更新个数
                    } else if (dp[j] + 1 == dp[i]) {//2.如果出现长度相等的子序列,那么计数+1
                        count[i] += count[j];
                    }
                }
            }
            maxCount = Math.max(maxCount, dp[i]);//记录所有最大长度,因为这里dp[i]仅代表的是以num[i]结尾的最长子序列
        }
        for (int i = 0; i < dp.length; i++) {//遍历所有的最大长度
            if (dp[i] == maxCount) {//找到最大长度
                res += count[i];//答案等于数目累加
            }
        }
        return res;
    }
}
