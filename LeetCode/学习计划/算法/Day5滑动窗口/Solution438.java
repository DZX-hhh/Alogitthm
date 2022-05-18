package LeetCode.学习计划.算法.Day5滑动窗口;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Solution438 {
    /*
        滑动窗口
     */
    public List<Integer> findAnagrams(String s, String p) {
        if (p.length() > s.length()) {
            return new LinkedList<>();
        }
        HashMap<Character, Integer> mapP = new HashMap<>();
        HashMap<Character, Integer> mapS = new HashMap<>();
        //哈希表记录p串的元素个数
        for (int i = 0; i < p.length(); i++) {
            mapP.put(p.charAt(i), mapP.getOrDefault(p.charAt(i), 0) + 1);
        }
        List<Integer> res = new ArrayList<>();
        int fast = 0, slow = 0;
        int valid = 0;
        while (fast < s.length()) {
            char c = s.charAt(fast);
            fast++;
            //当mapP中有的元素才加入到mapS中
            if (mapP.get(c) != null) {
                mapS.put(c, mapS.getOrDefault(c, 0) + 1);
                if (mapS.get(c).equals(mapP.get(c))) {
                    valid++;
                }
            }

            while (fast - slow >= p.length()) {
                if (valid == mapP.size()) {
                    res.add(slow);
                }
                char d = s.charAt(slow);
                slow++;
                if (mapP.get(d) != null) {
                    //窗口滑动导致p串中的有效字符数减少
                    if (mapP.get(d).equals(mapS.get(d))) {
                        valid--;
                    }
                    mapS.put(d, mapS.getOrDefault(d, 0) - 1);
                }
            }
        }
        return res;
    }
}
