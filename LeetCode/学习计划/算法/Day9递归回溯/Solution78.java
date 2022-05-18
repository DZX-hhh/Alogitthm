package LeetCode.学习计划.算法.Day9递归回溯;

import java.util.LinkedList;
import java.util.List;

public class Solution78 {
    /*
        类似于全排列问题-->子集问题-->回溯
     */ LinkedList<Integer> onPath = new LinkedList<>();
    List<List<Integer>> res = new LinkedList<>();

    /**
     * 想象成一个决策树
     * 1.做出选择
     * 2.递归
     * 3.撤销选择
     */
    public List<List<Integer>> subsets(int[] nums) {
        dfs1(nums, 0);
        dfs2(nums, 0);
        return res;
    }

    /*
        决策1.0
     */
    private void dfs1(int[] nums, int start) {
        res.add(new LinkedList<>(onPath));//将每一个结果存入列表,第一次加的是空列表
        if (start >= nums.length) {
            return;
        }
        for (int i = start; i < nums.length; i++) {//这里对start后的每一个元素做出选择
            //1.选择
            onPath.add(nums[i]);
            //2.递归
            dfs1(nums, i + 1);
            //3.撤销
            onPath.removeLast();
        }
    }

    /*
        决策2.0
     */
    private void dfs2(int[] nums, int start) {
        if (start >= nums.length) {
            res.add(new LinkedList<>(onPath));
            return;
        }
        //1.做出选择(考虑当前位置)
        onPath.add(nums[start]);
        //2.递归
        dfs2(nums, start + 1);
        //3.撤销选择(考虑当前位置)
        onPath.removeLast();

        //4.跳过当前位置不考虑
        dfs2(nums, start + 1);
    }
}
