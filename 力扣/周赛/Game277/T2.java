package 力扣.周赛.Game277;

import java.util.LinkedList;

public class T2 {
    public int[] rearrangeArray(int[] nums) {
        LinkedList<Integer> listOu = new LinkedList<>();
        LinkedList<Integer> listJi = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) listOu.add(nums[i]);
            else listJi.add(nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                nums[i] = listOu.removeFirst();
            } else nums[i] = listJi.removeFirst();
        }
        return nums;
    }
}
