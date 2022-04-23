package 力扣.学习计划.剑指Offer.Day7;

import 力扣.知识点.二叉树.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class T1 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false;
        //DFS(A,B) --当前节点B是否是A的子树,若不是,判断当前节点的孩子节点
        return dfs(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean dfs(TreeNode a, TreeNode b) {
        //当递归到子树的时候,,b已经到达了尽头,所以返回true,后面多出来的可能是a的
        if (b == null) return true;
        //当 a已经到达了尽头,,但是b还没到尽头,说明b并不是a的孩子节点
        if (a == null) return false;
        //如果二者都不为空,,并且当前值相等,那么就递归孩子节点
        return (a.val == b.val) && dfs(a.left, b.left) && dfs(a.right, b.right);
    }
}

//序列化
class Solution {
    Map<String, Integer> tree = new HashMap();
    List<TreeNode> answer = new LinkedList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return answer;
    }

    //返回序列化子树
    private String traverse(TreeNode root) {
        if (root == null) {
            return "#";
        }
        //得到序列化后的左子树
        String leftTree = traverse(root.left);
        //得到序列化后的右子树
        String rightTree = traverse(root.right);
        //后序遍历-自底向上地构建序列化子树-不断比较返回的子树是否已经存在
        String treeSub = root.val + "," + leftTree + "," + rightTree;
        int count = tree.getOrDefault(treeSub, 0);
        //如果存在该子树
        if (count == 1) {
            //将该子树根节点存入结果集
            answer.add(root);
        }
        //子树数量递增
        tree.put(treeSub, count + 1);
        return treeSub;
    }
}


class T2 {
    /* 交换左右孩子节点*/
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        //递归
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }
}

class T3 {
    //递归DFS,,左对右,右对左
    public boolean isSymmetric(TreeNode root) {
        return dfs(root.left, root.right);
    }

    public boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        else if ((left == null && right != null) || (left != null && right == null)) return false;
        return left.val == right.val && dfs(left.right, right.left) && dfs(left.left, right.right);
    }

    /**
     * @param root
     * @return 迭代BFS, , 队列
     */
    public boolean isSymmetric2(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        //用队列保存节点
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        //将根节点的左右孩子放到队列中
        queue.add(root.left);
        queue.add(root.right);
        while (queue.size() > 0) {
            //从队列中取出两个节点，再比较这两个节点
            TreeNode left = queue.removeFirst();
            TreeNode right = queue.removeFirst();
            //如果两个节点都为空就继续循环，两者有一个为空就返回false
            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }
            //将左节点的左孩子， 右节点的右孩子放入队列
            queue.add(left.left);
            queue.add(right.right);
            //将左节点的右孩子，右节点的左孩子放入队列
            queue.add(left.right);
            queue.add(right.left);
        }

        return true;
    }
}
