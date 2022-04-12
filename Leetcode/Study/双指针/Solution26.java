package Leetcode.Study.双指针;

public class Solution26 {
    /**
     * 千万不要忘记nums已经排序了
     * 直接构建数组
     */
    public int removeDuplicates1(int[] nums) {
        int index = 0;//直接重新构建数组
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[index]) {//当出现不重复元素
                nums[++index] = nums[i];
            }
        }
        return index + 1;
    }

    /**
     * 快慢指针指针方法
     *
     * @param nums
     * @return
     */
    public int removeDuplicates2(int[] nums) {
        if (nums.length < 2) return nums.length;
        //快慢指针
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {//如果快指针找到不重复的元素
//                记录
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow+1;
    }
}
