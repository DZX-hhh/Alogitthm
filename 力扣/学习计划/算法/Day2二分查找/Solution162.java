package 力扣.学习计划.算法.Day2二分查找;

public class Solution162 {
    //峰值---`上坡必有坡顶`
    //规律一：如果nums[i] > nums[i+1]，则在i之前一定存在峰值元素
    //规律二：如果nums[i] < nums[i+1]，则在i+1之后一定存在峰值元素
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;
        //处理`边界为峰值`的情况
        if (nums[0] > nums[1]) return 0;
        if (nums[n - 1] > nums[n - 2]) return n - 1;

        int left = 0, right = n - 2, res = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]) {
                res = mid;
                break;
            } else if (nums[mid] < nums[mid + 1]) {//说明mid+1处必然有峰值
                left = mid + 1;
            } else {//反之mid之前存在峰值
                right = mid - 1;
            }
        }
        return res;
    }
}