package LeetCode.周赛.Game73;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public int mostFrequent(int[] nums, int key) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == key) {
                map.put(nums[i + 1], map.getOrDefault(nums[i + 1], 0) + 1);
                int t = 2;
                while (i + t < nums.length && nums[i + t] == nums[i + t - 1]) {
                    map.put(nums[i + 1], map.getOrDefault(nums[i + 1], 0) + 1);
                    t++;
                }
            }
        }
        int max = 0;
        int target = nums[1];
        for (int i : map.keySet()) {
            if (map.get(i) > max) {
                max = map.get(i);
                target = i;
            }
        }
        return target;
    }

    int[] mapping;

    public int[] sortJumbled(int[] mapping, int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();//存放映射后的值
        List<Integer> list = new ArrayList<>();
        this.mapping = mapping;
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
            map.put(nums[i], toNewNum(nums[i]));
        }
        //将list排序,规则就是按照映射map比较
        Collections.sort(list, (a, b) -> map.get(a) - map.get(b));
        for (int i = 0; i < nums.length; i++) {
            nums[i] = list.get(i);
        }
        return nums;
    }

    /**
     * @param num
     * @return 返回num映射后的值
     */
    public int toNewNum(int num) {
        String s = String.valueOf(num);
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            ans += ans * 10 + mapping[s.charAt(i) - '0'];
        }
        return ans;
    }
}
