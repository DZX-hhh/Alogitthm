package 力扣.每日一题.Five.Day12;

public class Solution944 {
    public int minDeletionSize(String[] strs) {
        int res = 0;
        int m = strs.length, n = strs[0].length();
        for (int i = 0; i < n; i++) {//遍历每个字符串的第i位,排序
            for (int j = 0; j < m - 1; j++) {//遍历所有的字符串
                char char1 = strs[j].charAt(i);//定义前面一个列
                char char2 = strs[j + 1].charAt(i);//定义后面一个列
                if (char1 > char2) {
                    res++;
                    break;
                }
            }
        }
        return res;
    }
}
