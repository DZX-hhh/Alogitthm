package 力扣.知识点.二叉树.二叉树序列化和反序列化.后续遍历;

import 力扣.知识点.二叉树.TreeNode;

import java.util.LinkedList;

public class Codec {
    String SEP = ",";
    String NULL = "#";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        ser(root, sb);
        return sb.toString();
    }

    public void ser(TreeNode root, StringBuffer sb) {
        if (root == null) {
            sb.append(NULL).append(SEP);
            return;
        }
        ser(root.left, sb);
        ser(root.right, sb);
        sb.append(root.val).append(SEP);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> res = new LinkedList<>();
        for (String s : data.split(SEP)) {
            res.addLast(s);
        }
        return desr(res);
    }

    public TreeNode desr(LinkedList<String> res) {
        if (res.isEmpty()) {
            return null;
        }
        //由于后序遍历,从后往前取出元素
        String s = res.removeLast();
        if (s.equals(NULL)) {
            return null;
        }
        //先构造右子树,再构造左子树
        TreeNode root = new TreeNode(Integer.parseInt(s));
        root.right = desr(res);
        root.left = desr(res);
        return root;
    }
}
