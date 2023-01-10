package LeetCode.学习计划.算法.Day17动态规划;

public class Solution583 {
    /*
        此题和最长公共子序列类似
        动态规划:dp[i][j]表示长度为[0,i-1]的word1,长度为[0,j-1]的word2的最长公共子序列长度
                i,j从1开始
                dp[i][j]=max(dp[i-1][j-1]+1,dp[i-1][j],dp[i][j-1])
                答案等于两个word分别剪去最长公共子序列的长度和
     */
    public int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return len1 + len2 - 2 * dp[len1][len2];
    }
}
