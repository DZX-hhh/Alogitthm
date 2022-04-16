package 力扣.每日一题.Four.Four11;

public class Solution {
    /**
     * 排列组合
     *
     * @param n 位数
     * @return n=2时,0<x<100;考虑只有1位的情况+两位的情况
     * 两位:考虑第一位有1~9个选择,第二位有0~9中除去第一位的情况
     * 因此:推出含有n位(2<=n<=8)位数都不同的个数
     * 9*A₉ⁿ⁻¹  再累加小于n位的答案
     */
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 10;
        }
        //1位的已经考虑了,现在考虑在第2到第n位的每位可选数
        int res = 10;
        //cur表示当前有可能的选择数,这里第一位不能为0.因此是9
        int cur = 9;
        //这里代表第2位到第n位
        for (int i = 2; i <= n; i++) {
            cur *= 9 - i + 2;//第2位是9,第三位是8
            res += cur;
        }
        return res;
    }
}