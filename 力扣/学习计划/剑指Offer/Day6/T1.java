package 力扣.学习计划.剑指Offer.Day6;


import 力扣.知识点.二叉树.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class T1 {
    //层序遍历,,使用队列,,一般也称为BFS
    public int[] levelOrder(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) return new int[]{};
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll != null) {
                res.add(poll.val);
                //如果左孩子为空,那么访问之后就不需要再将其加入队列了
                if (poll.left != null) queue.offer(poll.left);
                if (poll.right != null) queue.offer(poll.right);
            }
        }
        int[] ansArr = new int[res.size()];
        for (int i = 0; i < ansArr.length; i++) {
            ansArr[i] = res.get(i);
        }
        return ansArr;
    }
}

class T2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> integerList = new LinkedList<>();
        if (root == null) return res;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        integerList.add(root.val);
        res.add(integerList);
        while (!queue.isEmpty()) {
            List<Integer> list = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.offer(poll.left);
                    list.add(poll.left.val);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                    list.add(poll.right.val);
                }
            }
            if (!list.isEmpty()) res.add(list);
        }
        return res;
    }
}


class T3 {
    //双端队列
    //根据res.size判断奇数层或是偶数层
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            LinkedList<Integer> list = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (res.size() % 2 == 0) {
                    list.addLast(poll.val);
                } else {
                    list.addFirst(poll.val);
                }
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            res.add(list);
        }
        return res;
    }
}