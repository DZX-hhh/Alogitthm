package LeetCode.每日一题.Five.Day21;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    /*
        set去重
     */
    public int repeatedNTimes(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length / 2 + 1);
        for (int n : nums) {
            if (!set.add(n)) {
                return n;
            }
        }
        return 0;
    }

    /*
        排序取中
     */
    public int repeatedNTimes2(int[] nums) {
        Arrays.sort(nums);
        int mid = nums.length / 2;
        return nums[mid] == nums[mid + 1] ? nums[mid] : nums[mid - 1];
    }
}
