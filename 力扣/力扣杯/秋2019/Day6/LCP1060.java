package 力扣.力扣杯.秋2019.Day6;

public class LCP1060 {
    //二分法,求missing()等于k的!!!右边界
    public int missingElement(int[] nums, int k) {
        int len = nums.length;
        if (k > missing(nums, len - 1)) {
            //如果缺失的数字超过了数组里面缺失数最大值
            //那么就返回最后最后一个值+(k-数组含有的缺失数)
            return nums[len - 1] + (k - missing(nums, len - 1));
        }

        int left = 0, right = len - 1, mid;
        while (left <= right) {
            //中间位置
            mid = left + (right - left);
            //如果从最左边到mid位置的缺失数>k,说明需要压缩
            if (missing(nums, mid) > k) {
                right = mid - 1;
            } else if (missing(nums, mid) < k) {
                left = mid + 1;
            } else if (missing(nums, mid) == k) {
                right = mid - 1;
            }
        }
        //nums[right]为缺失数等于k的右边界,,从right开始数
        // 加上[0,right]已经存在的缺失数
        // "k-已经缺失的"=还需要的 k-missing(nums,left)
        return nums[right] + (k - missing(nums, right));
    }

    /**
     * @param nums
     * @param index
     * @return 数组从最左边到index含有的缺失数
     */
    public int missing(int[] nums, int index) {
        return nums[index] - nums[0] - index;
    }
}
