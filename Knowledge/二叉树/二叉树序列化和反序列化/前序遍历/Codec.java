package LeetCode.知识点.二叉树.二叉树序列化和反序列化.前序遍历;

import LeetCode.知识点.二叉树.TreeNode;

import java.util.LinkedList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Codec {

    String SEP = ",";
    String NULL = "#";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        //先序遍历
        StringBuffer sb = new StringBuffer();
        seri(root, sb);
        return sb.toString();
    }

    public void seri(TreeNode root, StringBuffer sb) {
        if (root == null) {
            sb.append(NULL).append(SEP);
            return;
        }
        /*
         * 前序位置
         */
        sb.append(root.val).append(SEP);
        seri(root.left, sb);
        seri(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        //将字符串转化成列表
        LinkedList<String> nodes = new LinkedList<>();
        for (String s : data.split(SEP)) {
            nodes.addLast(s);
        }
        return desri(nodes);
    }

    //通过列表构造二叉树
    public TreeNode desri(LinkedList<String> nodes) {
        if (nodes.isEmpty()) {
            return null;
        }
        String first = nodes.removeFirst();
        if (first.equals(NULL)) {
            return null;
        }
        //先序遍历,列表最左侧就是根节点
        TreeNode root = new TreeNode(Integer.parseInt(first));
        root.left = desri(nodes);
        root.right = desri(nodes);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));