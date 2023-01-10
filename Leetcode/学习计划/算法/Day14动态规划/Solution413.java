package LeetCode.学习计划.算法.Day14动态规划;

public class Solution413 {
    /*
        找规律:
              (1,2,3) res=1  add=1-0=1
              (1,2,3,4) res=3 add=3-1=2
              (1,2,3,4,5) res=6 add=6-3=3
              (1,2,3,4,5,6) res=10 add=10-6=4
              (1,2,3,4,5,6,3) res=10 add=10-10=0
              1.当末尾出现的数字等差数列规律,add+=1
              2.否则,add=0
     */
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums == null || nums.length <= 2) {
            return 0;
        }
        int res = 0, add = 0;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                res += ++add;
            } else {
                add = 0;
            }
        }
        return res;
    }

    /*
    动态规划
             dp[i]含义:以nums[i]结尾的等差数列个数有几个
             递推方程:如果刚出现的元素符合等差数列规律,dp[i]=dp[i-1]+1-->也就是说,相比于之前多了当前末尾元素这种情况
                     然后将dp[i]全部加起来即可
     */
    public int numberOfArithmeticSlices2(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        int res = 0;
        int[] dp = new int[nums.length];
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {//符合等差规律,就更新答案
                dp[i] = dp[i - 1] + 1;
                res += dp[i];
            }
            //反之说明dp[i]=0,从新来过
        }
        return res;
    }
}
