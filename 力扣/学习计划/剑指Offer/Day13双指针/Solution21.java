package 力扣.学习计划.剑指Offer.Day13双指针;

public class Solution21 {
    public int[] exchange(int[] nums) {
        if (nums.length <= 1) {
            return nums;
        }
        int left = 0, right = nums.length - 1;
        while (left < right) {//奇数偶数未必个数相等
            if (nums[left] % 2 == 1) {//如果前半部分为奇数,继续
                left++;
            } else {//出现偶数
                while (right > left && nums[right] % 2 == 0) {
                    right--;//找到右半部分奇数
                }
                if (right <= left) {//如果已经到达边界,直接返回
                    return nums;
                }
                if (nums[right] % 2 == 1) {//后半部分出现奇数,,那么就让  前半部分出现的偶数 与 后半部分出现的奇数  交换位置
                    int t = nums[left];
                    nums[left] = nums[right];
                    nums[right] = t;
                    right--;
                }
            }
        }
        return nums;
    }
}