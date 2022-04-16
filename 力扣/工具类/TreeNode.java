package 力扣.工具类;

import java.util.Deque;
import java.util.LinkedList;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode (){}
    public TreeNode (int val){
        this.val = val;
    }

    @Override
    public String toString() {
        return "Leetcode.LeetcodeTool.Study.二叉树.TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    /**
     * 将LeetCode上的数组转换为TreeNode结构
     * @param arr 给定的数组, 参数之所以使用Integer是因为null
     * @return 生成的TreeNode
     */
    public static TreeNode array2Tree (Integer[] arr){
        if (arr.length < 1){
            return new TreeNode();
        } else {
            TreeNode root = new TreeNode(arr[0]);
            int i = 0;
            int arrLen = arr.length;
            // 用于bfs
            Deque<TreeNode> queue = new LinkedList<>();
            queue.addLast(root);
            while (queue.size() > 0){
                TreeNode treeNode = queue.removeFirst();
                int temp = (i<<1) + 1;
                if (treeNode != null && temp < arrLen){
                    if (arr[temp] != null){
                        treeNode.left = new TreeNode(arr[temp]);
                    }
                    temp++;
                    if (temp < arrLen){
                        if (arr[temp] != null){
                            treeNode.right = new TreeNode(arr[temp]);
                        }
                    }
                    queue.addLast(treeNode.left);
                    queue.addLast(treeNode.right);
                }
                i++;
            }
            return root;
        }
    }
}

