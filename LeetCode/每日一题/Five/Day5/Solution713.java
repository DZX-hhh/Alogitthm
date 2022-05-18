package LeetCode.每日一题.Five.Day5;

public class Solution713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        int multi = 1;
        int left = 0, right = 0, res = 0;
        while (right < nums.length) {
            multi *= nums[right];
            while (multi >= k) {
                multi /= nums[left];
                left++;
            }
            res += right - left + 1;
            right++;
        }
        return res;
    }
}
