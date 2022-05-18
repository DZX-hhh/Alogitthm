package LeetCode.学习计划.剑指Offer.Day15搜索与回溯;

import LeetCode.知识点.二叉树.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Solution34 {
    /*
        DFS+回溯:搜索路径和为target的叶子节点的列表
     */
    LinkedList<Integer> onPath = new LinkedList<>();
    LinkedList<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        dfs(root, target);
        return res;
    }

    private void dfs(TreeNode root, int target) {
        if (root == null) {
            return;
        }
        //1.1做出选择
        onPath.add(root.val);
        target -= root.val;
        //1.2判断是或否要继续选择,也就是到达叶子节点是否和恰好为target
        if (target == 0 && root.left == null && root.right == null) {
            res.add(new LinkedList<>(onPath));
            onPath.removeLast();//做出选择并撤销选择
            return;
        }
        //2.递归DFS
        dfs(root.left, target);
        dfs(root.right, target);
        //3.撤销选择
        onPath.removeLast();
    }
}
