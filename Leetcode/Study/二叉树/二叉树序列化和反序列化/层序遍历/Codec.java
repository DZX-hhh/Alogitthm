package Leetcode.Study.二叉树.二叉树序列化和反序列化.层序遍历;


import Leetcode.Study.二叉树.TreeNode;

import java.util.LinkedList;
import java.util.Queue;


public class Codec {

    String SEP = ",";
    String NULL = "#";

    /**
     * 层序遍历,使用队列解决
     * 步骤:父节点出队,同时左右孩子节点入队
     *
     * @param root
     * @return
     */
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuffer sb = new StringBuffer();
        if (root == null) {
            return "";
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode tempNode = queue.poll();
            //如果节点为空,则进入下一次循环
            if (tempNode == null) {
                sb.append(NULL).append(SEP);
                continue;
            } else {//如果不为空,则将其孩子节点入队做父节点
                sb.append(tempNode.val).append(SEP);

                //子节点递归进队列
                queue.offer(tempNode.left);
                queue.offer(tempNode.right);
            }

        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        //储存节点的数组
        String[] res = data.split(SEP);
        //创建根节点
        TreeNode root = new TreeNode(Integer.parseInt(res[0]));
        //队列记录  父节点
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        for (int i = 1; i < res.length && !queue.isEmpty(); ) {
            //弹出父节点
            TreeNode parent = queue.poll();
            //判断左右子节点是否为空
            //获取孩子节点的 val值
            String left = res[i++];
            //如果不为空,就创建左孩子节点,并且将这个节点作为父节点入队
            if (!left.equals(NULL)) {
                parent.left = new TreeNode(Integer.parseInt(left));
                queue.offer(parent.left);
            } else {
                parent.left = null;
            }
            //获取孩子节点的val值
            String right = res[i++];
            //如果不为空,就创建右孩子节点,并且将这个节点作为父节点入队
            if (!right.equals(NULL)) {
                parent.right = new TreeNode(Integer.parseInt(right));
                queue.offer(parent.right);
            } else {
                parent.right = null;
            }
        }
        return root;
    }
}