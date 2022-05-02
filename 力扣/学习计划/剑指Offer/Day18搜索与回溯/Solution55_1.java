package 力扣.学习计划.剑指Offer.Day18搜索与回溯;

import 力扣.知识点.二叉树.TreeNode;

public class Solution55_1 {

    public int maxDepth(TreeNode root) {
        return dfs(root);
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(dfs(root.left), dfs(root.right));
    }
}
