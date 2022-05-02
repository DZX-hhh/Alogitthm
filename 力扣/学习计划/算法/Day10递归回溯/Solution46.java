package 力扣.学习计划.算法.Day10递归回溯;

import java.util.LinkedList;
import java.util.List;

public class Solution46 {
    /*
        全排列问题,dfs回溯做选择
     */
    LinkedList<Integer> onPath = new LinkedList<>();
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        dfs(nums);
        return res;
    }

    private void dfs(int[] nums) {
        //如果全部选择,那就更新答案
        if (onPath.size() == nums.length) {
            res.add(new LinkedList<>(onPath));
            return;
        }
        for (int num : nums) {
            //跳过已经选择的路
            if (onPath.contains(num)) {
                continue;
            }
            //1.选择
            onPath.add(num);
            //2.递归
            dfs(nums);
            //3.撤销
            onPath.removeLast();
        }
    }
}
