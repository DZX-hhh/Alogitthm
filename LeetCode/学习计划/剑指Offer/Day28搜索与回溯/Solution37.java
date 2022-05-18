package LeetCode.学习计划.剑指Offer.Day28搜索与回溯;

import LeetCode.知识点.二叉树.TreeNode;

import java.util.LinkedList;

public class Solution37 {

}

/**
 * 序列化以及反序列化
 */
class Codec {

    String SEP = ",";
    String NULL = "#";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        seri(root, sb);
        return sb.toString();
    }

    private void seri(TreeNode root, StringBuffer sb) {
        if (root == null) {
            sb.append(NULL).append(SEP);
            return;
        }
        sb.append(root.val);
        seri(root.left, sb);
        seri(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> nodes = new LinkedList<>();
        for (String s : data.split(SEP)) {
            nodes.addLast(s);
        }
        return desri(nodes);
    }

    private TreeNode desri(LinkedList<String> nodes) {
        if (nodes.isEmpty()) {
            return null;
        }
        String first = nodes.removeFirst();
        TreeNode root = new TreeNode(Integer.parseInt(first));
        root.left = desri(nodes);
        root.right = desri(nodes);
        return root;
    }
}
