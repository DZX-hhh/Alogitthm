package LeetCode.学习计划.算法.Day15动态规划;

public class Solution494 {
    /**
     * "01"背包
     * 将数组分为正子集P和负子集N
     * 求sum(P)-sum(N)=target
     * 两边都加上sum(P)+sum(N)
     * --> sum(P)-sum(N)+sum(p)+sum(N)=target+sum(P)+sum(N)
     * -->   2 * sum(P) = target + sum(nums)
     * 因此这里target+sum(num)需要为偶数,并且target绝对值小于sum(nums)
     *
     * @param nums   -->物品
     * @param target -->背包
     * @return dp[target]:含义:运算结果为target的'表达式'的个数
     */
    public int findTargetSumWays(int[] nums, int target) {
        int sumNums = 0;
        for (int num : nums) {
            sumNums += num;
        }
        if (sumNums < Math.abs(target) || (target + sumNums) % 2 == 1) {
            return 0;
        }
        return bag(nums, (target + sumNums) / 2);
    }

    private int bag(int[] nums, int sum) {
        int[] dp = new int[sum + 1];
        dp[0] = 1;
        for (int j = 0; j < nums.length; j++) {//物品
            for (int i = sum; i >= nums[j]; i--) {//背包,这里倒序是为了只能使用一次,,如果是正序的话,那么说明可以使用多次
                dp[i] += dp[i - nums[j]];
            }
        }
        return dp[sum];
    }

    /*
        枚举法
     */
    int count = 0;

    public int findTargetSumWays2(int[] nums, int target) {
        dfs(nums, target, 0, 0);
        return count;
    }

    private void dfs(int[] nums, int target, int sum, int index) {
        if (index == nums.length) {
            if (target == sum) {
                count++;
            }
        } else {
            dfs(nums, target, sum + nums[index], index + 1);
            dfs(nums, target, sum - nums[index], index + 1);
        }
    }
}
