package 力扣.学习计划.算法.Day5滑动窗口;

public class Solution713 {
    /*
        滑动窗口
     */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        //排除k为1的情况
        if (k <= 1) {
            return 0;
        }
        int res = 0;
        int multi = 1;//乘积
        int left = 0, right = 0;
        while (right < nums.length) {
            multi *= nums[right];//更新乘积
            while (multi >= k) {//当乘积不满足条件,让左指针右移
                multi /= nums[left];
                left++;
            }
            /*
               这里为什么让res+=(right-left+1)而不是res++呢?
               因为如果是当右指针移动到新的位置,,结果增加以下情况
               nums[right]
               nums[right-1],nums[right]
               nums[right-2],nums[right-1],nums[right]
               nums[left].............................nums[right]
               这里显然增加了right到left的距离个,也就是right-left+1
             */
            res += right - left + 1;
            //右指针右移动
            right++;
        }
        return res;
    }
}
