package 力扣.周赛.Game277;

import java.util.Arrays;

public class T1 {
    public int countElements(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > nums[0] && nums[i] < nums[nums.length - 1]) {
                count++;
            }
        }
        return count;
    }
}
