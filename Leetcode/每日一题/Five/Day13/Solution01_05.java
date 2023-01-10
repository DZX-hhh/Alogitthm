package LeetCode.每日一题.Five.Day13;

public class Solution01_05 {
    /*
        与编辑距离类似
        可以增加删除修改元素
        dp[i][j]:first的前i个字母,second的前j个字母
        dp[i][j]=min(dp[i-1][j-1]+1,dp[i][j-1]+1,dp[i-1][j]+1)
                       修改            增加          删除
     */
    public boolean oneEditAway(String first, String second) {
        int len1 = first.length(), len2 = second.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= len2; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (first.charAt(i - 1) == second.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];//不需要修改
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        return dp[len1][len2] <= 1;
    }
}
