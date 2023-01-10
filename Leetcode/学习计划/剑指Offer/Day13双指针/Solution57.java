package LeetCode.学习计划.剑指Offer.Day13双指针;

import java.util.HashMap;

public class Solution57 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{nums[i], target - nums[i]};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }

    /*
        对撞双指针
     */
    public int[] twoSum2(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                return new int[]{nums[left], nums[right]};
            } else if (nums[left] + nums[right] > target) {
                right--;
            } else if (nums[left] + nums[right] < target) {
                left++;
            }
        }
        return null;
    }

    /*
        二分查找:先二分缩小范围,,再对撞双指针
     */
    public int[] twoSum3(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        //1.先二分缩小范围
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[left] + nums[mid] > target) {
                right = mid - 1;
            } else if (nums[right] + nums[mid] < target) {
                left = mid + 1;
            } else {
                break;
            }
        }
        if (left >= right) {
            return null;
        }
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                return new int[]{nums[left], nums[right]};
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else if (nums[left] + nums[right] > target) {
                right--;
            }
        }
        return null;
    }
}
