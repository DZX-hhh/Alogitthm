package 力扣.Top100.easy.Solution283;

public class Solution1 {

    /**
     * 快慢指针方法:快指针找非零元素存慢指针
     * fast:主要是遍历数组
     * slow:主要是记录非零的元素,被覆盖的位置,,最后slow到fast(也就是末尾)全是0
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                //如果快指针不为0,也就是没出现,同时更新慢指针
                //如果为0,就不记录,直接跳过,继续循环
                nums[slow++] = nums[fast];
            }
        }
        for (int i = slow; i < nums.length; i++) {
            nums[i] = 0;
        }
    }


}
