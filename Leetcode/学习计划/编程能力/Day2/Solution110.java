package LeetCode.学习计划.编程能力.Day2;

import LeetCode.知识点.二叉树.TreeNode;

public class Solution110 {
    public boolean isBalanced(TreeNode root) {
        boolean flag = true;
        //如果高度超过1,返回flag
        if (Math.abs(hight(root.left) - hight(root.right)) > 1) {
            flag = false;
        }
        //递归,,深度优先搜索
        return flag && isBalanced(root.left) && isBalanced(root.right);
    }

    /*
        计算根节点的高度
    */
    public int hight(TreeNode root) {
        if (root == null) return 0;
        int count = 1;
        count += Math.max(hight(root.left), hight(root.right));
        return count;
    }
}
