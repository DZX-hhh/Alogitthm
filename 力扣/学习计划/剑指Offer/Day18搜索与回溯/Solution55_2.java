package 力扣.学习计划.剑指Offer.Day18搜索与回溯;

import 力扣.知识点.二叉树.TreeNode;

public class Solution55_2 {
    /*
        递归1.0,有很多冗余运算
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(dfs(root.left) - dfs(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(dfs(root.left), dfs(root.right));
    }

    /*
        递归2.0,后序遍历+剪枝
     */
    public boolean isBalanced2(TreeNode root) {
        return dfs2(root) != -1;
    }

    /**
     * @return 如果为-1:说明不是平衡二叉树
     * 如果不为-1,就是数的高度
     */
    private int dfs2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = dfs2(root.left);
        int rightHeight = dfs2(root.right);
        if (leftHeight == -1 || rightHeight == -1) {
            //左右子树存在不平衡子树,直接返回-1
            return -1;
        }
        return Math.abs(leftHeight - rightHeight) <= 1 ? Math.max(leftHeight, rightHeight) + 1 : -1;
    }
}
