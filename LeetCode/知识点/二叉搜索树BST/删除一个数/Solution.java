package LeetCode.知识点.二叉搜索树BST.删除一个数;

import LeetCode.知识点.二叉树.TreeNode;

public class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            //情况1:当目标删除节点左右孩子为空,直接删除
            if (root.right == null)
                //情况2:当目标删除节点存在孩子节点是但不全是null,直接让不为空的那一个子节点顶替
                return root.left;
            if (root.left == null) {
                return root.right;
            }
            //情况3:目标删除节点左右子节点都不为null,需要找到可以顶替的节点(比如左子树的最大值,右子树的最小值)
            TreeNode newRoot = getMin(root.right);
            root.val = newRoot.val;//替换节点的值,然后删除右子树顶替的节点,因为他已经顶替了前面的删除的位置了
            //更新删除后的右孩子节点
            root.right = deleteNode(root.right, newRoot.val);
        }

        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        }
        return root;
    }

    /**
     * 获取最小的节点
     * BST最左边的就是最小值
     *
     * @param root
     * @return 返回最小值(最左节点)
     */
    public TreeNode getMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
}
