package LeetCode.学习计划.算法.Day1二分查找;

public class Solution34 {
    //二分法
    public int[] searchRange(int[] nums, int target) {
        return searchLeft(nums, target) > searchRight(nums, target) ? new int[]{-1, -1} :
                new int[]{searchLeft(nums, target), searchRight(nums, target)};
    }

    //找target的左边界
    public int searchLeft(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] == target) {
                right = mid - 1;
            }
        }
        return left;
    }

    //找target的右边界
    public int searchRight(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] == target) {
                left = mid + 1;
            }
        }
        return right;
    }
}
