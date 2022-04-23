package 力扣.学习计划.剑指Offer.Day8动态规划;

public class T1 {
    /*直接使用递归,,超时,,重复计算量过多*/
    public int fib(int n) {
        if (n <= 1) return n;
        return fib(n - 1) + fib(n - 2);
    }

    /*解决重复计算的问题,,使用一个数组作为备忘录,,计算了结果,那么就直接使用这个结果,而不需要再递归计算,*/
    int FIB[] = new int[101];

    public int fib2(int n) {
        if (n <= 1) return n;
        if (FIB[n] != 0) {
            //数组默认为0,,当不为0的说明已经计算过,,可以直接使用
            return FIB[n];
        }
        return FIB[n] = (int) ((fib(n - 1) + fib(n - 2)) % (1e9 + 7));
    }

    /*动态规划,,也是维护一个备忘录数组,,知道后面返回[n]即可*/
    public int fib3(int n) {
        int mod = 1000000007;
        if (n <= 1) return n;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % mod;
        }
        return dp[n];
    }
}
