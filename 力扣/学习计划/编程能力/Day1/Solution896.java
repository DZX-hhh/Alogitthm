package 力扣.学习计划.编程能力.Day1;

public class Solution896 {
    /**
     * 当出现nums[i]>nums[i+1],说明不存在单调递增
     * 当出现nums[i]<nums[i+1],说明不存在单调递减
     *
     * @param nums
     * @return 返回是否单调增加或者减少
     */
    public boolean isMonotonic(int[] nums) {
        if (nums.length <= 2) return true;
        boolean increase = true, decrease = true;//初始化都为true
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                increase = false;
            }
            if (nums[i] < nums[i + 1]) {
                decrease = false;
            }
        }
        return increase || decrease;
    }
}
