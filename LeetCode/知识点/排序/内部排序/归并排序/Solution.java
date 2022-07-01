package LeetCode.知识点.排序.归并排序;

import java.util.Arrays;

public class Solution {

    public static int[] temp;

    /**
     * 归并排序就是先把左半边数组排好序，再把右半边数组排好序，然后把两半数组合并。
     * 二叉树的高度是logN，其中每一层的元素个数就是原数组的长度N，所以总的时间复杂度就是O(NlogN)。
     *
     * @param nums
     * @return
     */
    public int[] sortArray(int[] nums) {
        //辅助合并有序数组
        temp = new int[nums.length];
        //排序数组
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    /**
     * 定义:排序nums[low,high]
     *
     * @param nums
     * @param low
     * @param high
     */
    public void sort(int[] nums, int low, int high) {
        if (low == high) {
            return;
        }
        //归并排序,中电下标
        int mid = (low + high) / 2;
        //利用定义,排序nums[low,mid]
        sort(nums, low, mid);
        //利用定义,排序nums[mid+1,high]
        sort(nums, mid + 1, high);

        //两个子数组排好序
        //合并两个有序数组,使nums[low,high]有序
        merge(nums, low, mid, high);
    }

    /**
     * 合并两个有序数组
     *
     * @param nums
     * @param low
     * @param mid
     * @param high
     */
    public void merge(int[] nums, int low, int mid, int high) {
        //复制到辅助数组当中
        temp = Arrays.copyOf(nums, high - low+1);

        //双指针合并有序数组
        int slow = low;
        int fast = mid + 1;
        for (int i = low; i <= high; i++) {
            if (slow > mid) {
                nums[i] = temp[fast++];
            } else if (fast > high) {
                nums[i] = temp[slow++];
            } else if (temp[slow] < temp[fast]) {
                nums[i] = temp[slow++];
            } else if (temp[fast] < temp[slow]) {
                nums[i] = temp[fast++];
            }
        }
    }

}
