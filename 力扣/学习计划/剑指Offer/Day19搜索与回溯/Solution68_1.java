package 力扣.学习计划.剑指Offer.Day19搜索与回溯;

import 力扣.知识点.二叉树.TreeNode;

public class Solution68_1 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        //两个节点都在root左边
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        //两个节点都在root右边
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        //一左一右,那么最近祖先就是root
        return root;
    }
}
