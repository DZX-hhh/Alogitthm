package 力扣.周赛.Game291;

import java.util.*;

public class Solution {
    public String removeDigit(String number, char digit) {
        String res = "";
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == digit) {
                if (res.equals("")) {
                    res = number.substring(0, i) + number.substring(i + 1);
                } else {
                    res = res.compareTo(number.substring(0, i) + number.substring(i + 1)) > 0 ? res : (number.substring(0, i) + number.substring(i + 1));
                }
            }
        }
        return res;
    }

    public int minimumCardPickup(int[] cards) {
        int min = Integer.MAX_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < cards.length; i++) {
            if (map.containsKey(cards[i])) {
                min = Math.min(min, i - map.get(cards[i]) + 1);
            }
            map.put(cards[i], i);
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }


    /*
        这里连续不重复子数组使用`set`去重
     */
    public int countDistinct(int[] nums, int k, int p) {
        Set<List<Integer>> set = new HashSet<>();
        //暴力枚举,尝试每一个可行的连续子数组
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            List<Integer> list = new LinkedList<>();
            for (int j = i; j < nums.length; j++) {
                if (nums[j] % p == 0) {
                    count++;
                }
                if (count > k) {
                    break;
                }
                list.add(nums[j]);//这里记录每一个新的连续子数组
                set.add(new LinkedList<>(list));//这里将记录的新的连续子数组加入set判断是否重复
            }
        }
        return set.size();
    }
}