package LeetCode.周赛.Game285;

import java.util.HashMap;
import java.util.LinkedList;

public class Solution {
    public int countHillValley(int[] nums) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        LinkedList<Integer> list = new LinkedList<>();
        list.add(nums[0]);
        for (int num : nums) {
            if (list.getLast() != num) {
                list.add(num);
            }
        }

        for (int i = 1; i < list.size(); i++) {
//            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
//                count++;
//            }
//            if (nums[i] < nums[i - 1] && nums[i] < nums[i + 1]) {
//                count++;
//            }
            if (list.get(i) > list.get(i - 1) && list.get(i) > list.get(i + 1)) {
                count++;
            }
            if (list.get(i) < list.get(i - 1) && list.get(i) < list.get(i + 1)) {
                count++;
            }
        }
        return count;
    }
}