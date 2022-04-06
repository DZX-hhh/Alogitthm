package Leetcode.WeekGame.WeekGame287;

public class Solution {
    long max = 0;

    /**
     * Study.二分查找,题目和珂珂猴子类似
     * 小孩拿糖果可以是1,也可以全部都拿
     *
     * @param candies
     * @param k
     * @return
     */
    public int maximumCandies(int[] candies, long k) {
        long l = 1;
        long r = max;
        while (l < r) {
            //每个孩子拿min个
            long mid = (l+r-1) / 2;
            //cnt记录可以分多少堆
            long cnt = 0;
            for (int candy : candies) {
                cnt += candy / mid;//分堆,如果candy/m=2,说明分成了2堆
            }
            if (cnt < k) {//如果满足不了条件
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        return (int) l;
    }

    public long max(int[] candies) {
        for (int candy : candies) {
            max = Math.max(max, candy);
        }
        return max;
    }
}
