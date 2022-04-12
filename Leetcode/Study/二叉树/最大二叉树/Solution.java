package Leetcode.Study.二叉树.最大二叉树;

import Leetcode.Study.二叉树.TreeNode;

public class Solution {
    /**
     * 二叉树重点在于搞清楚根节点要做什么
     * 这里显然是要找到子数组的最大值以及下标
     * 然后前序递归调用
     *
     * @param nums
     * @return
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return bulid(nums, 0, nums.length - 1);
    }

    public TreeNode bulid(int[] nums, int low, int high) {
        //base case
        if (low > high) {
            return null;
        }
        /*
         * 找到字数组最大值,以及下标
         */
        int index = -1;
        int max = Integer.MIN_VALUE;
        for (int i = low; i <= high; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        //构造根节点
        TreeNode root = new TreeNode(max);
        //递归构造根节点的左右子树
        root.left = bulid(nums, low, index - 1);
        root.right = bulid(nums, index + 1, high);
        return root;
    }
}
