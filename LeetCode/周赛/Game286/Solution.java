package LeetCode.周赛.Game286;

import java.util.*;

public class Solution {

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> res1 = new ArrayList<>();
        List<Integer> res2 = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            set2.add(nums2[i]);
        }
        for (int num : nums1) {
            if (!set2.contains(num)) {
                if (!res1.contains(num)) {
                    res1.add(num);
                }
            }
        }
        for (int num : nums2) {
            if (!set1.contains(num)) {
                if (!res2.contains(num)) {
                    res2.add(num);
                }
            }
        }
        res.add(res1);
        res.add(res2);
        return res;
    }


    public int minDeletion(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        Deque<Integer> stack = new LinkedList<>();
        stack.push(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            /**
             * 保证i%2==0的情况下,nums[i]!=nums[i+1]
             */
            //如果栈内元素为2的倍数,可以直接push元素
            if (stack.size() % 2 == 0) {
                stack.push(nums[i]);
            } else {
                //栈内元素不为2的倍数,说明需要push的元素必须得是不等于当前栈顶元素,否则就继续循环
                if (stack.peek() == nums[i]) {
                    continue;
                }
                stack.push(nums[i]);
            }
        }
        if (stack.size() % 2 == 0) {
            return nums.length - stack.size();
        } else {
            //如果不能是2 的倍数,那么就需要再删除栈顶元素
            return nums.length - stack.size() + 1;
        }
    }
}
