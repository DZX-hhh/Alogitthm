package 力扣.Top100.easy.Solution448;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * 利用hash表,一个萝卜一个坑,遍历,出现了x就让nums[x-1]+n,重复的数字也任然只会在同一个位置再次加n
     * 修改过nums之后再遍历数组
     * 如果没出现,数组保留的就是原本身的数字<=n
     *
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        for (int num : nums) {
            //避免出现过,取余得到初始值
            nums[(num % n) - 1] += n;
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                list.add(i + 1);
            }
        }
        return list;
    }
}
