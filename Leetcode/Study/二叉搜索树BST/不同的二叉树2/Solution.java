package Leetcode.Study.二叉搜索树BST.不同的二叉树2;

import Leetcode.Study.二叉树.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    /**
     * 构建所有的搜索二叉树
     *
     * @param n
     * @return
     */
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<>();
        }
        return build(1, n);
    }

    /**
     * 以i为根节点构造所有的BST
     * 本质:递归排列组合
     *
     * @param low
     * @param high
     * @return
     */
    public List<TreeNode> build(int low, int high) {
        List<TreeNode> res = new LinkedList<>();
        if (low > high) {
            res.add(null);
            return res;
        }
        for (int i = low; i <= high; i++) {
            //1.递归
            //构造左右孩子的左右BST的列表
            List<TreeNode> leftList = build(low, i - 1);
            List<TreeNode> rightList = build(i + 1, high);
            //2.穷举所有的孩子节点,排列组合
            for (TreeNode left : leftList) {
                for (TreeNode right : rightList) {
                    //3.分别构造父节点
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
