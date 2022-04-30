package 力扣.学习计划.剑指Offer.Day16排序;

import java.util.Arrays;
import java.util.HashSet;

public class Solution61 {
    /*
        这里为顺子的条件:1.不存在重复  2.max-min<5,否则就超出范围了,就算有大小王无法弥补顺子
     */
    public boolean isStraight(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num == 0) {
                continue;
            }
            if (!set.add(num)) {//出现重复,返回false(大小王例外)
                return false;
            }
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        return max - min < 5;
    }

    //最小值为除去王的值,最大值为nums[4]
    public boolean isStraight2(int[] nums) {
        Arrays.sort(nums);
        int jokerNums = nums[0] == 0 ? 1 : 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0) {
                jokerNums++;
                continue;
            }
            if (nums[i] == nums[i - 1]) {
                return false;
            }
        }
        return nums[4] - nums[jokerNums] < 5;
    }
}
