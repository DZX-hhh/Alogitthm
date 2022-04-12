package Leetcode.Study.滑动窗口;

import java.util.HashMap;

public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        int len = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            /*
             *窗口扩大 数据更新操作
             */
            window.put(c, window.getOrDefault(c, 0) + 1);

            //收缩窗口
            while (window.get(c) > 1) {//出现次数大于1,也就是出现重复字符
                char d = s.toCharArray()[left];
                left++;
                /*
                 *收缩窗口 数据更新操作
                 */
                window.put(d, window.getOrDefault(d, 1) - 1);
            } /*
             *更新最长字串的长度
             */
            len = Math.max(len, right - left);
        }
        return len;
    }
}
