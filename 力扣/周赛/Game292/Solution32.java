package 力扣.周赛.Game292;

public class Solution32 {
    /**
     * dp[i]:以下标i字符结尾的最长有效括号的子串长度
     */
    public int longestValidParentheses(String s) {
        int length = s.length();
        int[] dp = new int[length];
        int res = 0;
        for (int i = 1; i < length; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = i - 2 >= 0 ? dp[i - 2] + 2 : 2;//初始化
                } else if (dp[i - 1] > 0) {//情况2:
                    int preIdx = (i - dp[i - 1] - 1);
                    if (preIdx >= 0 && s.charAt(preIdx) == '(') {
                        dp[i] = dp[i - 1] + 2;
                        if (preIdx - 1 >= 0) {
                            dp[i] = dp[i - 2] + 2 + dp[preIdx - 1];
                        }
                    }
                }
            }
            res = Math.max(res, dp[i]);//比较最大值
        }
        return res;
    }
}
