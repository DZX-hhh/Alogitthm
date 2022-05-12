package 力扣.学习计划.算法.Day20其他;

import java.util.Random;

/*
    也就是随机洗牌算法
    遍历数组,不断交换i和[i,n-1]的任意一个值
 */
public class Solution384 {
    int[] nums;
    Random random;

    public Solution384(int[] nums) {
        this.nums = nums;
        random = new Random();
    }

    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {
        int[] res = nums.clone();
        for (int i = 0; i < nums.length; i++) {
            swap(res, i, i + random.nextInt(nums.length - i));
        }
        return res;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
}
