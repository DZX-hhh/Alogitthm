package LeetCode.学习计划.剑指Offer.Day10动态规划;

public class T1 {
    public static int translateNum(int num) {
        if (num < 10) return 1;
        char[] chars = String.valueOf(num).toCharArray();
        int[] dp = new int[chars.length];
        //base case,第一个格子只能跳一格
        dp[0] = 1;
        //初始化dp[1],这个比较特殊,前面只有dp[0]一位
        int t = (chars[0] - '0') * 10 + chars[1] - '0';
        dp[1] = t >= 10 && t <= 25 ? 2 : 1;
        for (int i = 2; i < dp.length; i++) {
            int temp = (chars[i - 1] - '0') * 10 + chars[i] - '0';
            if (temp >= 10 && temp <= 25) {//如果第i个和第i-1个能够成为一个新的结果
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[dp.length - 1];
    }
}
