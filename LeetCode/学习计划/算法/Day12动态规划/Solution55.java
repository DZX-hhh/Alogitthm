package LeetCode.学习计划.算法.Day12动态规划;

public class Solution55 {
    /*
        贪心:维护能够到达的最远距离
        遍历数组,判断最远距离是否能够覆盖当前位置,并比较最远距离和i+nums[i]
     */
    public boolean canJump(int[] nums) {
        if (nums.length <= 1) {
            return true;
        }
        int maxDistance = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (maxDistance >= i) {//能够到达
                maxDistance = Math.max(maxDistance, i + nums[i]);
            } else {
                return false;
            }
        }
        return true;
    }
}
