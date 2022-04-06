package Leetcode.LeetcodeStudy.二叉搜索树BST.第K小的元素;

import Leetcode.LeetcodeStudy.二叉树.TreeNode;

public class Solution {

    public int kthSmallest(TreeNode root, int k) {
        seri(root, k);
        return res;
    }

    int count = 0;
    int res = 0;

    public void seri(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        seri(root.left, k);
        count++;
        if (count == k) {
            root.val = res;
            return;
        }
        seri(root.right, k);
    }
}
