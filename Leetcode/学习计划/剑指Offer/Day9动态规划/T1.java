package LeetCode.学习计划.剑指Offer.Day9动态规划;

public class T1 {
    /**
     * @param nums
     * @return 动态规划
     */
    public int maxSubArray(int[] nums) {
        int maxRes = nums[0];//最大值
        int prev = 0;//前置合
        for (int i = 0; i < nums.length; i++) {
            prev = Math.max(prev + nums[i], nums[i]);//比较,判断当前元素是否需要加上之前前置和(如果加了更小,那不如不加)
            maxRes = Math.max(maxRes, prev);//更新答案
        }
        return maxRes;
    }
}
