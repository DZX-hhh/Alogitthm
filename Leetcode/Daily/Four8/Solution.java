package Leetcode.Daily.Four8;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

public class Solution {
    /**
     * 广度优先搜索
     * 层序遍历使用队列
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Deque<Node> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            //这一层的所有节点数
            int count = deque.size();
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < count; i++) {
                Node poll = deque.poll();
                list.add(poll.val);
                for (Node node : poll.children) {
                    deque.offer(node);
                }
            }
            res.add(list);
        }
        return res;
    }
}

