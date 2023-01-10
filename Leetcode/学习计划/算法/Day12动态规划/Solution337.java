package LeetCode.学习计划.算法.Day12动态规划;

import LeetCode.知识点.二叉树.TreeNode;

import java.util.HashMap;

public class Solution337 {
    /**
     * 这里层序遍历实际上是不可行的,,[2,1,3,null,4]不符合一层一层的规律
     * 考虑到相邻两个房子不能偷
     * -->偷父节点,,左右孩子就不能偷了
     * -->不偷父节点,,可`考虑`左右孩子是否要偷
     * 比较二者最大值
     */
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }
        //偷父节点,跳过左右孩子
        int val1 = root.val;
        if (root.left != null) {
            val1 += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            val1 += rob(root.right.left) + rob(root.right.right);
        }
        //不偷父节点,考虑左右孩子
        int val2 = rob(root.left) + rob(root.right);
        return Math.max(val1, val2);
    }

    //上面超时了,因为左右子树存在重复计算
    //这里使用哈希表记录每一次计算的结果,如果哈希表存在结果,就直接用,没有就继续算
    HashMap<TreeNode, Integer> map = new HashMap<>();

    public int rob2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }
        if (map.containsKey(root)) {
            return map.get(root);
        }
        //偷父节点,跳过左右孩子
        int val1 = root.val;
        if (root.left != null) {
            val1 += rob2(root.left.left) + rob2(root.left.right);
        }
        if (root.right != null) {
            val1 += rob2(root.right.left) + rob2(root.right.right);
        }
        //不偷父节点,考虑左右孩子
        int val2 = rob2(root.left) + rob2(root.right);
        map.put(root, Math.max(val1, val2));
        return Math.max(val1, val2);
    }


    /**
     * 动态规划记录偷和不偷的最大值,并由此推导后面的最大值
     */
    public int rob3(TreeNode root) {
        int[] dp = robTree(root);
        return Math.max(dp[0], dp[1]);
    }

    /**
     * @param root 是否偷当前节点的最值
     * @return 返回一个长度为2的dp数组, 这里dp[0]代表不偷当前节点的最大值, , dp[1]代表偷当前节点的最大值
     */
    private int[] robTree(TreeNode root) {
        //当前节点为空,最大值都为0,这里也是初始化dp[]
        if (root == null) {
            return new int[]{0, 0};
        }
        //后序遍历,因为要作为参数使用
        int[] robLeft = robTree(root.left);
        int[] robRight = robTree(root.right);
        int[] dp = {0, 0};
        //偷当前节点,返回当前节点值+左右子节点不偷的最值
        dp[1] = root.val + robLeft[0] + robRight[0];
        //不偷当前节点
        // 考虑左孩子节点的偷与不偷的最大值
        // 考虑右孩子节点的偷与不偷的最大值
        dp[0] = Math.max(robLeft[0], robLeft[1]) + Math.max(robRight[0], robRight[1]);
        return dp;
    }
}
