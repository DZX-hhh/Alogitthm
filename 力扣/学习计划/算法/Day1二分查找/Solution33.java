package 力扣.学习计划.算法.Day1二分查找;

public class Solution33 {
    /**
     * 非递归版,两部分有一部分为有序,有序部分通过最大值最小值,判断target是否在有序的部分,还是在无序的部分
     */
    public int search(int[] nums, int target) {
        //return search(nums, 0, nums.length - 1, target);
        int len = nums.length;
        int left = 0, right = len - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < nums[right]) {//右半边部分有序
                if (nums[mid] < target && target <= nums[right])//如果target在右半部分,left=mid+1
                    left = mid + 1;
                else//否则就只能跳到左半部分了
                    right = mid - 1;
            } else {
                if (nums[left] <= target && target < nums[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            }
        }
        return -1;
    }


    /**
     * 递归版
     */
    public int search(int[] nums, int left, int right, int target) {
        if (left > right) return -1;
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) return mid;
        if (nums[mid] < nums[right]) {//说明右半部分有序
            if (nums[mid] < target && target <= nums[right]) {//如果target在最小值和最大值之间,那么就查找右半有序部分,否则的话递归查找左半部分
                return search(nums, mid + 1, right, target);
            } else {
                return search(nums, left, mid - 1, target);
            }
        } else {//反之说明左半部分有序
            if (nums[left] <= target && nums[mid] > target) {
                return search(nums, left, mid - 1, target);
            } else {
                return search(nums, mid + 1, right, target);
            }
        }
    }
}
