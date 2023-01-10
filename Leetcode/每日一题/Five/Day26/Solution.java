package LeetCode.每日一题.Five.Day26;

public class Solution {
    /**
     * 动态规划:dp[i]:表示p[i] `结尾` 的连续子串的长度
     * 1.p[i-1]=p[i],,count++
     * -->此时,最长字符为dp[p[i]-`a`]=max(dp[p]-'a',count)
     * 2.p[i-1]!=p[i],,count=1
     * -->此时,最长字符也为dp[p[i]-`a`]=max(dp[p]-'a',count)
     */
    public int findSubstringInWraproundString(String p) {
        int count = 1, res = 0;
        int[] dp = new int[26];
        char[] chars = p.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i > 0 && (chars[i] - chars[i - 1] == 1 || chars[i - 1] - chars[i] == 25)) {
                count++;
            } else {
                count = 1;
            }
            dp[chars[i] - 'a'] = Math.max(count, dp[chars[i] - 'a']);//叠加
        }
        for (int i = 0; i < dp.length; i++) {
            res += dp[i];
        }
        return res;
    }
}
