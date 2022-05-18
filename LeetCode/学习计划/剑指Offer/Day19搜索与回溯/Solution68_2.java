package LeetCode.学习计划.剑指Offer.Day19搜索与回溯;

import LeetCode.知识点.二叉树.TreeNode;

public class Solution68_2 {
    /*
        1.p,q在root两边
        2.p,q都在root左边
        3.p,q都在root右边
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (p == root || q == root) {
            return root;
        }
        //寻找左右子树是否含有p或者q
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {///这个时候说明left和right都找到了p或则q,,说明p,q在两边
            return root;
        } else {//这里说明只可能存在一边,只要有一边为空,那么必然在都在另外一边
            return left != null ? left : right;
        }
    }
}