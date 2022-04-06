package Leetcode.LeetcodeStudy.二叉树.前序和中序构造二叉树;

import Leetcode.LeetcodeStudy.二叉树.TreeNode;

public class Solution {
    /**
     * 首先清楚根结点干什么
     * 这里先确定根节点的值,然后递归构造左右子树
     *
     * @param preorder 前序遍历数组
     * @param inorder  中序遍历数组
     * @return
     */
    TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 1) {
            return new TreeNode(preorder[0]);
        }
        return build(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    /**
     * @param preorder 前序遍历数组
     * @param preStart 开始索引
     * @param preEnd   结束索引
     * @param inorder  中序遍历数组
     * @param inStart  开始索引
     * @param inEnd    结束索引
     * @return 返回的是构造二叉树的根节点
     */
    public TreeNode build(int[] preorder, int preStart, int preEnd,
                          int[] inorder, int inStart, int inEnd) {
        //base case 考虑边界,递归推出条件
        if (preStart > preEnd) {
            return null;
        }
        //root 节点对应的是前序遍历数组的第一个元素
        //并由此在中序数组里面  分割成左右子树
        int rootval = preorder[preStart];
        //中序遍历数组的索引
        int indexInorder = 0;
        //这里是为了找到根节点的下标,也就是等于inorder[i]的rootval的index
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootval) {
                indexInorder = i;
                break;
            }
        }

        /**
         * 确定根节点值之后,构造根节点
         * 递归构造左右子树
         * indexInorder为中序遍历根节点的下标
         */
        TreeNode root = new TreeNode(rootval);
        //算出左子树大小,以此确定先序遍历数组边界
        int leftSize = indexInorder - inStart;
        //构造左子树
        root.left = build(preorder, preStart + 1, preStart + leftSize,
                inorder, inStart, indexInorder - 1);
        //构造右子树
        root.right = build(preorder, preStart + leftSize + 1, preEnd,
                inorder, indexInorder + 1, inEnd);

        return root;
    }
}
/*
 * https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247487270&idx=1&sn=2f7ad74aabc88b53d94012ceccbe51be&scene=21#wechat_redirect
 */

