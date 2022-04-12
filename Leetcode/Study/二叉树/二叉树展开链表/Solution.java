package Leetcode.Study.二叉树.二叉树展开链表;

import Leetcode.Study.二叉树.TreeNode;

public class Solution {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.left);
        flatten(root.right);
        /**
         先拉平各子树,拉成单链表
         */
        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;
        root.left = null;
        root.right = leftNode;//将左节点作为右节点

        /**
         将原右子树连接到当前右节点后
         */
        TreeNode currRight = root;
        while (root.right != null) {
            root = root.right;
        }//找到当前右孩子为空的右节点,并接上
        root.right = rightNode;
    }
}
