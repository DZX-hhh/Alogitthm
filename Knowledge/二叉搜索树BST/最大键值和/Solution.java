package LeetCode.知识点.二叉搜索树BST.最大键值和;

import LeetCode.知识点.二叉树.TreeNode;
public class Solution {
    //定义一个全局变量
    int maxSum = 0;

    /**
     * 1.遍历判断是否为二叉搜索树
     * 2.将键值和加起来
     * 3.求最大
     *
     * @param root
     * @return
     */
    public int maxSumBST(TreeNode root) {
        traverse(root);
        return maxSum;
    }

    /**
     * @param root
     * @return int[]{isBST,min,max,sum}
     */
    public int[] traverse(TreeNode root) {
        //base case
        if (root == null) {
            return new int[]{
                    1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0
            };
        }
        //递归访问左右子树
        int[] left = traverse(root.left);
        int[] right = traverse(root.right);
        //后序----通过左右子树推导返回值,并更新maxSum
        int[] res = new int[4];
        //1.if判断以root为根的二叉树是否为BST----左右子树都为BST并且左子树的最大值小于roo.val,右子树的最小值大于root.val
        if (left[0] == 1 && right[0] == 1 && left[2] < root.val && right[1] > root.val) {
            //root是BST
            res[0] = 1;
            //更新root的min
            res[1] = Math.min(left[1], root.val);
            //更新root的max
            res[2] = Math.max(right[2], root.val);
            //求出当前总和,并更新sum
            res[3] = left[3] + right[3] + root.val;
            maxSum = Math.max(maxSum, res[3]);
        } else {
            //不是BST,那么就只需要更新res[0],其他的不需要,用不到
            res[0] = 0;
        }
        return res;
    }
}
