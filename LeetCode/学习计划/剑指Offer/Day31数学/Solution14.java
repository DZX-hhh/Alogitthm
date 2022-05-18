package LeetCode.学习计划.剑指Offer.Day31数学;

public class Solution14 {

    /*         这里行不通,因为n最大为1000,会产生大数越界情况        */

    /**
     * @param n 要拆分的数
     * @return dp[n]:整数n拆分的乘积最大值
     * dp[i]=max(dp[i],(i-j)*j,dp[i-j]*j)
     * 表示:可以不拆分 以及拆分成2部分 以及拆分成多部分
     */
    public int cuttingRope(int n) {
        int mod = (int) (1e9 + 7);
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i] % mod, Math.max((i - j) * j % mod, dp[i - j] * j % mod)) % mod;
            }
        }
        return dp[n] % mod;
    }


    /**
     * 数学推论:
     * 1.将绳子 以相等的长度等分为多段 ，得到的乘积最大
     * 2.尽可能将绳子以长度 3 等分为多段时，乘积最大。
     */
    public int cuttingRope2(int n) {
        if (n <= 3) {
            return n - 1;
        }
        long res = 1;
        int mod = (int) (1e9 + 7);
        //贪心算法,优先切分3,其次切分2
        while (n > 4) {
            res = res * 3 % mod;
            n -= 3;
        }
        //跳出循环之后,只有三种情况n=2,3,4
        //在最后情况下可能剩余4个(res*3*1)<(res*2*2) 或者剩余2个(res*2) 或者剩余3个(res*3)
        return (int) (res * n % mod);
    }
}