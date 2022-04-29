package 力扣.学习计划.剑指Offer.Day15搜索与回溯;

import 力扣.知识点.二叉树.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Solution54 {
    List<Integer> list = new LinkedList<>();

    /*
        先序遍历
     */
    public int kthLargest(TreeNode root, int k) {
        postSearch(root);
        return list.get(list.size() - k);
    }

    private void postSearch(TreeNode root) {
        if (root == null) {
            return;
        }
        postSearch(root.left);
        list.add(root.val);
        postSearch(root.right);
    }

    /*
        '右-->根-->左`
        此时二叉搜索树为降序
     */
    int res = 0, count = 0;

    public int kthLargest2(TreeNode root, int k) {
        postSearch2(root, k);
        return res;
    }

    private void postSearch2(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        postSearch2(root.right, k);
        if (++count == k) {
            res = root.val;
            return;
        }
        postSearch2(root.left, k);
    }
}
