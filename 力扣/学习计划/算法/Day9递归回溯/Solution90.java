package 力扣.学习计划.算法.Day9递归回溯;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution90 {
    LinkedList<Integer> onPath = new LinkedList<>();
    List<List<Integer>> res = new LinkedList<>();

    /*
        这里考虑到会出现重复情况
        1.数组排序
        2.做选择之前 比较当前数是否与上一个数一样,如果是一样 那就重复了一样的选择,需要跳过
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(nums, 0);
        return res;
    }

    /*
        回溯
     */
    private void dfs(int[] nums, int start) {
        res.add(new LinkedList<>(onPath));
        if (start >= nums.length) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i - 1] == nums[i]) {
                //这里为了避免重复,需要做出与前一个不同的选择,跳过
                continue;
            }
            //1.选择(考虑当前位置)
            onPath.add(nums[i]);
            //2.递归
            dfs(nums, i + 1);
            //3.撤销
            onPath.removeLast();
        }
    }
}
