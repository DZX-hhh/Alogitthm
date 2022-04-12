package Leetcode.Study.二叉搜索树BST.插入一个数;

import Leetcode.Study.二叉树.TreeNode;

public class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        //找到空节点,然后插入进去
        if (root == null) {
            return new TreeNode(val);
        }
        /* 一般BST不插入已存在的节点
        if (val==root.val){
            return new TreeNode(val);
        }
        */
        if (root.val < val) {
            root.right = insertIntoBST(root.right, val);
        }
        if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        }
        //返回最终修改后的根节点
        return root;
    }
}
