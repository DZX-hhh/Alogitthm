package LeetCode.学习计划.算法.Day15动态规划;

public class Solution91 {
    /*
        动态规划:dp[i]含义当前解码总数
               递推方程:考虑到0没有译码,这里假设s[i-1]为a,s[i]为b
                  > dp[i]=dp[i-1]+dp[i-2]:意思是b既能单独一组,也可和a组队成ab-->10<=ab<=26 && b!=0
                  > dp[i]=dp[i-1]:意思是b只能单独一队,也就是a为0,b不为0  或者a>2的情况
                  > dp[i]=dp[i-2]:意思是b只能和a组队成ab,,这种情况下a为1或2 b为0的情况
     */
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') {//排除前置0
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        char[] arr = s.toCharArray();
        int[] dp = new int[arr.length];
        dp[0] = 1;
        if (1 <= arr[1] - '0' && arr[1] - '0' <= 9) {
            dp[1] = 1;
        }
        int t = (arr[0] - '0') * 10 + arr[1] - '0';
        if ((10 <= t && t <= 26)) {
            dp[1] += 1;
        }
        for (int i = 2; i < arr.length; i++) {
            int a = arr[i] - '0', b = (arr[i - 1] - '0') * 10 + arr[i] - '0';
            if (1 <= a && a <= 9) {//情况2,a能单独成对
                dp[i] = dp[i - 1];
            }
            if (10 <= b && b <= 26) {//情况1,3
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length() - 1];
    }
}
