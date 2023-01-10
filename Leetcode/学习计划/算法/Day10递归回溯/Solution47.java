package LeetCode.学习计划.算法.Day10递归回溯;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution47 {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> onPath = new LinkedList<>();

    /*
        去除重复排序+选不重复的选择
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] isValid = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums, isValid);
        return res;
    }

    private void dfs(int[] nums, boolean[] isValid) {
        if (onPath.size() == nums.length) {
            res.add(new LinkedList<>(onPath));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //当前位置的元素已经使用
            // 或者
            // 当前位置和前一个位置元素相等,并且前一个位置使用了,那当前位置如果再使用就会出现重复
            if (isValid[i] || (i > 0 && nums[i - 1] == nums[i]) && !isValid[i - 1]) {
                continue;
            }
            //1.选择
            isValid[i] = true;
            onPath.add(nums[i]);
            //2.递归
            dfs(nums, isValid);
            //3.撤销
            isValid[i] = false;
            onPath.removeLast();
        }
    }
}
