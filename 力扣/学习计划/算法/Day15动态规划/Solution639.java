package 力扣.学习计划.算法.Day15动态规划;

public class Solution639 {
    int mod = 1000000007;
    long[] dp = new long[100003];//这里dp[i+1]代表s[i]结尾的时候的情况总数

    public int numDecodings(String s) {
        char[] arr = s.toCharArray();
        dp[0] = 1;
        dp[1] = arr[0] == '*' ? 9 : 1;
        if (arr[0] == '0') {
            dp[0] = 0;
            dp[1] = 0;
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != '*') {//1.当arr[i]为数字
                if (arr[i] != '0') {
                    dp[i + 1] += dp[i];//1.1 arr[i]不为0,可以单独为一队
                }
                if (arr[i - 1] == '1' || (arr[i - 1] == '2' && arr[i] <= '6')) {
                    //1.3 arr[i]可以和arr[i-1]组合
                    dp[i + 1] += dp[i - 1];
                } else if (arr[i - 1] == '*') {//1.4 arr[i-1]为'*'
                    if (arr[i] <= '6') {
                        dp[i + 1] += 2 * dp[i - 1];//1.4.1 出现'1*'和'2*'的组合
                    } else {
                        dp[i + 1] += dp[i - 1];//1.4.2 出现'1*'的组合
                    }
                }
            } else {//2. 当arr[i]为'*'时
                dp[i + 1] += dp[i] * 9;//2.1 必然可单独一组
                if (arr[i - 1] == '1') {
                    dp[i + 1] += dp[i - 1] * 9;//2.2 出现'1*'的组合
                } else if (arr[i - 1] == '2') {
                    dp[i + 1] += dp[i - 1] * 6;//2.3 出现'2*'的组合
                } else if (arr[i - 1] == '*') {
                    dp[i + 1] += dp[i - 1] * 15;//2.4 出现'10'-'26'的组合
                }
            }
            dp[i + 1] %= mod;//取模运算
        }
        return (int) dp[arr.length];
    }
}
