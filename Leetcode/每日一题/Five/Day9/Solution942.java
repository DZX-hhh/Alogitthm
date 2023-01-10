package LeetCode.每日一题.Five.Day9;

public class Solution942 {
    /*
        贪心,如果是"D",那么只需要让res[i]等于当前最大值即可,"I"也同理
     */
    public int[] diStringMatch(String s) {
        int[] res = new int[s.length() + 1];
        int min = 0, max = s.length();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'I') {//这里说明是增加的,后面比前面大就行
                res[i] = min++;
            } else {
                res[i] = max--;
            }
        }
        res[s.length()] = min;
        return res;
    }
}
