package LeetCode.学习计划.剑指Offer.Day4查找;

import java.util.HashSet;

public class Solution {
    public int findRepeatNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return num;
            }
        }
        return -1;
    }


    //二分法
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};
        //求左边界
        int start = startSearch(nums, target);
        //求右边界
        int end = endSearch(nums, target);
        return start > end ? new int[]{-1, -1} : new int[]{start, end};
    }

    private int startSearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private int endSearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }


    public int missingNumber(int[] nums) {
        if (nums.length == 1) return nums[0] == 0 ? 1 : 0;
        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i]) return i;
        }
        return 0;
    }
}
