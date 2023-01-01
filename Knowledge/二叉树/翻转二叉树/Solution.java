package LeetCode.知识点.二叉树.翻转二叉树;

import LeetCode.知识点.二叉树.TreeNode;

public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return root;
        }
        invertTree(root.left);
        invertTree(root.right);
        TreeNode tempNode=root.left;
        root.left=root.right;
        root.right=tempNode;
        return root;
    }
}
