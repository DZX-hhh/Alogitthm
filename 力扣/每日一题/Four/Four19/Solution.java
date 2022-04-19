package 力扣.每日一题.Four.Four19;

public class Solution {
    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[] res = new int[n];

        //这里index为-n和2*n的初始情况考虑到刚开始的时候可能不存在
        //第一遍遍历是统计与左边的'c'的距离
        for (int i = 0, index = -n; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                index = i;
            }
            res[i] = i - index;
        }
        //第二次统计与右边的距离,这次要比较min值
        for (int i = n - 1, index = 2 * n; i >= 0; i--) {
            if (s.charAt(i) == c) {
                index = i;
            }
            res[i] = Math.min(res[i], index - i);
        }
        return res;
    }
}