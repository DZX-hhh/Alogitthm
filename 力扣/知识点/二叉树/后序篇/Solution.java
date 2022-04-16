package 力扣.知识点.二叉树.后序篇;

import 力扣.知识点.二叉树.TreeNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    /**
     * 思考:根节点做什么
     * 这里根节点要求   子树结构相同
     * *以我为根节点的 二叉树长啥样
     * *其他节点为根节点的二叉树长啥样
     *
     * @param root
     * @return
     */
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return res;
    }

    List<TreeNode> res = new LinkedList<>();
    HashSet<String> set = new HashSet<>();

    /**
     * 这里采用后续遍历,描述二叉树长啥样
     *
     * @param root
     * @return
     */
    String traverse(TreeNode root) {
        if (root == null) {
            return "#";
        }
        String left = traverse(root.left);
        String right = traverse(root.right);
        String ans = left + "," + right + "," + root.val;

        if (set.contains(ans) && !res.contains(root)) {
            res.add(root);
        } else {
            set.add(ans);
        }
        return ans;
    }

}
