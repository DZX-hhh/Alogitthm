package Leetcode.Study.排序.快速排序;

import java.util.Random;

//https://www.bilibili.com/video/BV1rV411j7f6?from=search&seid=14783962216563248953&spm_id_from=333.337.0.0
public class Solution {
    /**
     * @param nums
     * @return 快速排序
     */
    public int[] sortArray(int[] nums) {
        quick(nums, 0, nums.length - 1);
        return nums;
    }

    public void quick(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        int pilot = partition(nums, low, high);
        quick(nums, low, pilot - 1);
        quick(nums, pilot + 1, high);
    }

    public int partition(int[] nums, int low, int high) {
        Random random = new Random();
        //生成[low,high]的随机数
        int r = random.nextInt(high + 1 - low) + low;
        swap(nums, r, high);
        //i左边的小于nums[i],右边的大于nums[i]
        int i = low;
        for (int j = low; j <= high - 1; j++) {
            if (nums[j] <= nums[high]) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, high);
        return i;
    }

    public void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
