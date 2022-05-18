package LeetCode.学习计划.Top100.easy.Solution338;

public class Solution {
    public int[] countBits(int n) {
        int[] count = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            count[i] = Integer.bitCount(i);
        }
        return count;
    }
}