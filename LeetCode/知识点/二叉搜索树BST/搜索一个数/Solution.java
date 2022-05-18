package LeetCode.知识点.二叉搜索树BST.搜索一个数;

import LeetCode.知识点.二叉树.TreeNode;

public class Solution {
    /**
     * 利用二叉搜索树的特性:左小右大
     * 类似于二分查找
     *
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }
        if (val > root.val) {
            return searchBST(root.right, val);
        }
        if (val < root.val) {
            return searchBST(root.left, val);
        }
        return null;
    }
}
