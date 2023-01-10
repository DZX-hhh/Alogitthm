package LeetCode.学习计划.剑指Offer.Day20分治;

public class Solution16 {
    public double myPow(double x, int n) {
        return Math.pow(x, n);
    }

    /*
        快速幂
     */
    public double myPow2(double x, int n) {
        if (x == 0.0f) {
            return 0.0d;
        }
        long N = n;
        double res = 1.0;
        //将负数情况考虑
        if (n < 0) {
            N = -N;
            x = 1 / x;
        }
        //快速幂
        /*
        while (N > 0) {
            if (N % 2 == 0) {
                N /= 2;
                x *= x;
            } else {
                res *= x;
                N /= 2;
                x *= x;
            }
        }
        */
        //改进版  想象成分治法
        while (N > 0) {
            if ((N & 1) == 1) {// N & 1代表取出N的二进制最后一位
                res *= x;
            }
            N = N >> 1;//二进制右移等于除以2
            x *= x;//这里类似与
        }
        return res;
    }
}
