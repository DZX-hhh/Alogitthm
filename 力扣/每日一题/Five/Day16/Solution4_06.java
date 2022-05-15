package 力扣.每日一题.Five.Day16;

import 力扣.知识点.二叉树.TreeNode;

public class Solution4_06 {
    /*
        二叉搜索树
        中序遍历:有序列表
        寻找比p.val大的最小值
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }
        //当前节点小于等于目标节点值,那么目标值必然在当前节点的后面,,也就是右子树
        if (root.val <= p.val) {
            return inorderSuccessor(root.right, p);
        }
        //否则,说明当前节点值大于目标节点,答案可能是,也有可能需要向左边验证
        //验证root.left是否有比p.val大的更小值,,如果没有,那么当前节点就是答案
        TreeNode testLeft = inorderSuccessor(root.left, p);
        return testLeft == null ? root : testLeft;
    }
}
