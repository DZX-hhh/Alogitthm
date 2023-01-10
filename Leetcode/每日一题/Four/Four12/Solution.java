package LeetCode.每日一题.Four.Four12;

public class Solution {
    /**
     * @param widths
     * @param s
     * @return 一次循环, 如果满了这一行, 那么就跳到下一行, 并初始化width = widths[s.charAt(i) - 'a'];
     */
    public int[] numberOfLines(int[] widths, String s) {
        int width = 0;
        int row = 1;
        for (int i = 0; i < s.length(); i++) {
            width += widths[s.charAt(i) - 'a'];
            if (width > 100) {
                row++;
                width = widths[s.charAt(i) - 'a'];
            }
        }
        return new int[]{row, width};
    }
}
