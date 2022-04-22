package 力扣.每日一题.Four.Four22;

public class Solution {
    //找规律:类似于动态规划,,每次翻转等于当前的now+sum-nums.length*翻转的最后一个元素
    //不能直接在res上比较,,每次翻转都需要及时更新答案,也就是now
    public int maxRotateFunction(int[] nums) {
        int res = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            res += i * nums[i];
            sum += nums[i];
        }
        //记录当前结果
        int now = res;
        for (int k = 1; k < nums.length; k++) {
            now += sum - nums.length * nums[nums.length - k];//更新当前结果
            res = Math.max(res, now);//更新答案
        }
        return res;
    }
}
