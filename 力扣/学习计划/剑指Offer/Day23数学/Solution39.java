package 力扣.学习计划.剑指Offer.Day23数学;

import java.util.Arrays;

public class Solution39 {
    /*
        排序取中
     */
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /*
        摩尔投票:极限一换一,当出现不同的将二者同归于尽,最后留下来的全是相同的
     */
    public int majorityElement2(int[] nums) {
        int res = 0, count = 0;//count为当前留下的计数
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {//无一幸存的情况下,新人上任
                res = nums[i];
                count++;
            } else {
                count = res == nums[i] ? count + 1 : count - 1;//同存异忘
            }
        }
        return res;
    }
}
