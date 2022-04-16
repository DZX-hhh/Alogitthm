package 力扣.力扣杯.春2021.Day1;

import java.util.Arrays;

public class LCP28 {
    /*
        排序+双指针
     */
    public int purchasePlans(int[] nums, int target) {
        int mod = 1000000007;
        int left = 0;
        int right = nums.length - 1;
        int num = 0;
        Arrays.sort(nums);//排序保证更好确定预算的范围
        while (left < right) {
            if (nums[left] + nums[right] > target) {//超出预算,需要将贵的(right--)便宜一点
                right--;
            } else {
                //如果成功了,说明这个范围最便宜的+最贵的不超预算,那么最便宜的+任意一个不超过最贵的都可以
                num += right - left;
                left++;
            }
            num %= mod;
        }
        return num % mod;
    }
}
