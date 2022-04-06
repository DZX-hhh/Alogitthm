package Leetcode.LeetcodeStudy.滑动窗口;

import java.util.HashMap;

public class Solution567 {
    public static boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> window = new HashMap<>();
        HashMap<Character, Integer> need = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            need.put(s1.charAt(i), need.getOrDefault(s1.charAt(i), 0) + 1);
        }
        int valid = 0;
        int left = 0, right = 0;
        while (right < s2.length()) {
            char c = s2.charAt(right);
            right++;
            /*
             * 更新数据
             */
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            //判断窗口是否收缩
            while (right - left + 1 > s1.length()) {//寻找的字串应该是要等于目标字串的
                if (valid == s1.length()) {
                    return true;
                }
                char d = s2.charAt(left);
                left++;
                /*
                 * 更新数据
                 */
                if (need.containsKey(d)) {
                    if (need.get(d).equals(window.get(d))) {
                        valid--;
                    }
                    window.put(d, window.getOrDefault(d, 1) - 1);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "adc";
        String s2 = "dcba";
        System.out.println(checkInclusion(s1, s2));
    }
}
