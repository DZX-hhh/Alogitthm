package Leetcode.Study.二叉搜索树BST.累加树;

import Leetcode.Study.二叉树.TreeNode;

public class Solution {
    public TreeNode convertBST(TreeNode root) {
        // 利用 BST 的中序遍历特性
        traverse(root);
        return root;
    }

    // 记录结果累加
    int sum = 0;

    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        //由大到小递归
        traverse(root.right);
        /* 中序遍历代码位置 */
        sum += root.val;
        root.val = sum;
        /*****************/
        traverse(root.left);
    }
}