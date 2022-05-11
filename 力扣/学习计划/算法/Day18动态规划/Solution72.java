package 力扣.学习计划.算法.Day18动态规划;

public class Solution72 {
    /*
        dp[i][j]:word1的前i个字母和word2的前j个字母
        如果word1[i-1]==word[j-1],dp[i][j]=dp[i-1][j-1]
        反之,需要增加,删除,修改
        - 增加:word1增加元素word2[j]在i-1后的位置-->dp[i][j]=dp[i][j-1]+1
        - 删除:删除word1的第i位字母-->dp[i][j]=dp[i-1][j]
        - 修改:修改word1的第i位字母,使得和word2[j]一样-->dp[i][j]=dp[i-1][j-1]+1
        取最小
     */
    public int minDistance(String word1, String word2) {
        int length1 = word1.length(), length2 = word2.length();
        int[][] dp = new int[length1 + 1][length2 + 1];
        //初始化word2为空的情况
        for (int i = 0; i <= length1; i++) {
            dp[i][0] = i;
        }
        //初始化word1为空的情况
        for (int j = 0; j <= length2; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    /*                    1.修改                   2.删除             3.增加                */
                }
            }
        }
        return dp[length1][length2];
    }
}
