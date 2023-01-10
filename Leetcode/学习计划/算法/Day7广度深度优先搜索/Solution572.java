package LeetCode.学习计划.算法.Day7广度深度优先搜索;

import LeetCode.知识点.二叉树.TreeNode;

public class Solution572 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return dfs(root, subRoot);
    }

    public boolean dfs(TreeNode root, TreeNode subRoot) {
        if (root == null) {//已经遍历到root的所有节点,依旧没有找到相同结构,返回false
            return false;
        }
        return isSameTree(root, subRoot) || dfs(root.left, subRoot) || dfs(root.right, subRoot);
    }

    public boolean isSameTree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        } else if (root != null && subRoot != null) {
            if (root.val != subRoot.val) {
                return false;
            }
            return isSameTree(root.left, subRoot.left) && isSameTree(root.right, subRoot.right);
        } else {
            return false;
        }
    }
}
