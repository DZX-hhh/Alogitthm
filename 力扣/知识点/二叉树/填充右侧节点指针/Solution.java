package 力扣.知识点.二叉树.填充右侧节点指针;

import 力扣.知识点.二叉树.Node;

public class Solution {
    public Node connect(Node root) {
        if (root == null || root.left == null) {
            return root;
        }
        connectTwoNode(root.left, root.right);//将两个节点链接起来
        return root;
    }

    /**
     * 定义两个节点,将这两个节点链接起来
     *
     * @param left
     * @param right
     */
    private void connectTwoNode(Node left, Node right) {
        if (left == null || right == null) {
            return;
        }
        /**
         * 前序遍历
         */
        left.next = right;
        //先链接两个父节点,然后在连接子节点
        connectTwoNode(left.left, left.right);
        connectTwoNode(right.left, right.right);
        /**
         * 这一步解决  不是同一个父节点的两个节点链接起来
         */
        connectTwoNode(left.right, right.left);
    }
}
