package Leetcode.LeetcodeStudy.质数;

import java.util.Arrays;

public class Solution {
    /**
     * 埃氏筛
     * 如果 x 是质数，那么大于 x的 x的倍数 2x,3x,… 一定不是质数
     *
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        int count = 0;
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);
        for (int i = 2; i < n; i++) {
            if (isPrime[i] == 1) {
                count++;
                if ((long) i * i < n) {//防止溢出
                    for (int t = i * i; t < n; t += i) {
                        isPrime[t] = 0;
                    }
                }
            }
        }
        return count;
    }
}
