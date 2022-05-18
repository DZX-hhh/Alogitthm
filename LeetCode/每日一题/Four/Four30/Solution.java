package LeetCode.每日一题.Four.Four30;

public class Solution {
    /*
        题意:找到最大值和最小值-->(最大值-k,最小值+k)-->最大值-最小值-->如果大于0,就为答案
        反之说明这个数字都可以变换成一样的数字,因此答案为0
     */
    public int smallestRangeI(int[] nums, int k) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        return Math.max(max - min - 2 * k, 0);
    }
}
