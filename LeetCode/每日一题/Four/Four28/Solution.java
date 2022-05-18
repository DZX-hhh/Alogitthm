package LeetCode.每日一题.Four.Four28;

public class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[left] % 2 == 1) {//前半部分出现奇数
                while (left < right && nums[right] % 2 != 0) {//找到后半段的偶数
                    right--;
                }
                //交换这两个奇数偶数
                int t = nums[left];
                nums[left] = nums[right];
                nums[right] = t;
            }
            left++;
        }
        return nums;
    }
}
