package 力扣.学习计划.算法.Day14动态规划;

public class Solution5 {
    /*
        boolean[][]dp:dp[i][j]含义:[i..j]是否为回文串
        > 如果[i]!=[j],说明不可能是回文串,dp=false
        >如果[i]=[j],说明有可能是回文串
                       1.i==j,情况为"a",dp=true
                       2.j-1=1,情况为"aa",dp=false
                       3.j-i>1,情况为"cabac"-->"aba",dp[i][j]=dp[i+1][j-1]
                        这里依旧由下往上,有左往右遍历
     */
    public String longestPalindrome(String s) {
        int maxLength = 0;
        int left = 0, right = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1) {//情况1,2
                        dp[i][j] = true;
                    } else if (dp[i + 1][j - 1]) {//情况3
                        dp[i][j] = true;
                    }
                }
                //这里如果是回文串并且长度大于最大值,更新答案以及记录
                if (dp[i][j] && j - i + 1 > maxLength) {
                    maxLength = j - i + 1;
                    left = i;
                    right = j;
                }
            }
        }
        return s.substring(left, left + maxLength);
    }

    /*
        双指针:又称中心扩散法
     */
    int maxLeft = 0, maxRight = 0, maxLength = 0;

    public String longestPalindrome2(String s) {
        for (int i = 0; i < s.length(); i++) {
            extend(s, i, i, s.length());//以i为中心点
            extend(s, i, i + 1, s.length());//以i,i+1为中心点
        }
        return s.substring(maxLeft, maxLeft + maxLength);//截取最大字符串
    }

    /**
     * @param centerLeft  中心左端
     * @param centerRight 中心右端
     * @param len         字符串长度
     */
    private void extend(String s, int centerLeft, int centerRight, int len) {
        while (centerLeft >= 0 && centerRight < len && s.charAt(centerLeft) == s.charAt(centerRight)) {
            if (centerRight - centerLeft + 1 > maxLength) {
                maxLength = centerRight - centerLeft + 1;
                maxLeft = centerLeft;
                maxRight = centerRight;
            }
            centerLeft--;
            centerRight++;
        }
    }
}
