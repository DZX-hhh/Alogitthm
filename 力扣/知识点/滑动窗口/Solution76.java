package 力扣.知识点.滑动窗口;

import java.util.HashMap;

public class Solution76 {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> window = new HashMap<>();//窗口
        HashMap<Character, Integer> need = new HashMap<>();//记录目标字串需要的hash表
        for (int i = 0; i < t.length(); i++) {//将字串保存进去
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }
        int left = 0, right = 0;//滑动窗口的两个指针
        int valid = 0;//满足条件的字符数目
        int start = 0;//满足条件的开始位置
        int len = Integer.MAX_VALUE;//初始化字串长度
        while (right < s.length()) {
            //先让窗口扩大
            char c = s.charAt(right);//记录扩大的窗口的字符

            right++;//窗口扩大

            /*
             * 窗口内数据更新
             */
            if (need.containsKey(c)) {
                //如果新增的字符c属于目标字串
                window.put(c, window.getOrDefault(c, 0) + 1);//将新增c添加到窗口记录,之前不存在就默认为0+1
                if (window.get(c).equals(need.get(c))) {
                    //如果目标需要对应字符的数目等于当前窗口的该字符数目,valid++
                    valid++;
                }
            }

            //判断是否需要收缩窗口,只有当valid同时满足所有字母才能受挫
            while (valid == need.size()) {
                /*
                 * 判断,更新更小满足条件的字串
                 */
                if (right - left < len) {//如果长度小于上一个字串长度
                    len = right - left;//更新字串长度
                    start = left;//更新字串开始位置
                }

                char d = s.charAt(left);//暂存要移除的字符
                left++;//收缩窗口

                /*
                 *更新窗口内数据
                 */
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        //如果收缩窗口时,窗口含字母d与目标字串含字母d的数目相等
                        //那么当这个字母移除的时候,valid--;
                        valid--;
                    }
                    window.put(d, window.getOrDefault(d, 1) - 1);//将其对应的次数-1
                }
            }
        }
        //判断字串的长度是否更新过,如果没有更新过,说明没找到这个字串
        return len == Integer.MAX_VALUE ? "" : s.substring(start, len - start);//截取字串
    }
}
