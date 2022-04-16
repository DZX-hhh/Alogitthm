package 力扣.每日一题.Four.Four16;

public class Solution {
    /**
     * @param n
     * @return n位数*n位数的最大回文数的位数应该是2n,因此,通过max
     * (1: n位数由大到小,构造回文数
     * 2: 再由n位数 由大到小枚举,找到能被'当前构造的回文数'整除的
     * 那么也就说明存在另一个数(在后面)那么就结束)
     */
    public int largestPalindrome(int n) {
        int mod = 1337;
        if (n == 1) return 9;
        if (n == 2) return 99 * 91 % mod;
        //'n'位数,最大值
        int max = (int) Math.pow(10, n) - 1;
        for (int i = max; i >= 0; i--) {
            long t1 = i;
            long t2 = i;
            //1. 构造回文数
            while (t2 != 0) {
                t1 = t1 * 10 + t2 % 10;
                t2 /= 10;
            }
            //2. 找到能被回文数整除的,,这里判断条件,如果两个值中更大的值的平方都已经小于回文数了,
            //   那么,这个后面的数两两相乘只会更小,不符合
            for (long bigger = max; bigger * bigger >= t1; bigger--) {
                if (t1 % bigger == 0) {
                    return (int) (t1 % mod);
                }
            }
        }
        return 0;
    }
}
