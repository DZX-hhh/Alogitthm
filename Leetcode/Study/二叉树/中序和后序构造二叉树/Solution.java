package Leetcode.Study.二叉树.中序和后序构造二叉树;

import Leetcode.Study.二叉树.TreeNode;

public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, 0, inorder.length - 1,
                postorder, 0, postorder.length - 1);
    }

    /**
     * 先清楚根节点要干嘛
     * 先找出根节点的值,并创建
     * 递归创建左右子树
     *
     * @param inorder   中序遍历数组
     * @param inStart   开始下标
     * @param inEnd     结束下标
     * @param postorder 后序遍历数组
     * @param poStart   开始下标
     * @param poEnd     结束下标
     * @return 返回根节点
     */
    public TreeNode build(int[] inorder, int inStart, int inEnd,
                          int[] postorder, int poStart, int poEnd) {
        //base case
        if (inStart > inEnd) {
            return null;
        }
        //后序遍历,最后一个值为根节点的值
        int rootval = postorder[poEnd];
        //创建根节点
        TreeNode root = new TreeNode(rootval);
        //中序遍历找到根节点的值对应的下标
        int indexInorder = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootval) {
                indexInorder = i;
                break;
            }
        }
        int leftSize = indexInorder - inStart;
        root.left = build(inorder, inStart, indexInorder - 1, postorder, poStart, poStart + leftSize - 1);
        root.right = build(inorder, indexInorder + 1, inEnd, postorder, poStart + leftSize, poEnd - 1);
        return root;
    }
}
