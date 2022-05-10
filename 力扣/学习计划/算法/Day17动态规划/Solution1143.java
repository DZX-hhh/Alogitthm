package 力扣.学习计划.算法.Day17动态规划;

public class Solution1143 {
    /*
        动态规划:这里dp[i][j]依旧是长度为[0,i-1]的text1和长度为[0,j-1]的text2公共子序列长度
                i,j从1开始遍历
                dp[i][j]=max(dp[i-1][j-1]+1,dp[i-1][j],dp[i][j-1])
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int res = 0;
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {//说明找到公共元素s1[i-1]==s2[j-1]
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    //没找到公共元素,比较s1[i-1]和s2[j]
                    // 没找到公共元素,比较s1[i]和s2[j-1]
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}
