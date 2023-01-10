package LeetCode.每日一题.Five.Day3;

import java.util.Arrays;

public class Solution {
    public String[] reorderLogFiles(String[] logs) {
        String[] res = new String[logs.length];
        Arrays.sort(logs, (log1, log2) -> {
            //这里limit是切割次数
            String[] s1 = log1.split(" ", 2);
            String[] s2 = log2.split(" ", 2);
            //分割后的除标识符外的第一个字符都是数字
            boolean isDigit1 = Character.isDigit(s1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(s2[1].charAt(0));
            if (!isDigit1 && !isDigit2) {//如果都不是数字,是字母
                int compare = s1[1].compareTo(s2[1]);
                return compare != 0 ? compare : s1[0].compareTo(s2[0]);
            }
            //1.s1是数字  s2是字母  返回1,升序排列,让s2放在前面
            //2.s1是字母  s2是数字  返回-1,升序排列,让s1放在前面
            //3.s1是数字  s2是数字  返回0,不排序
            return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
        });
        return logs;
    }
}
