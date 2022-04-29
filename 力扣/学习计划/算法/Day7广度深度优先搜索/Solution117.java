package 力扣.学习计划.算法.Day7广度深度优先搜索;

import java.util.Deque;
import java.util.LinkedList;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

public class Solution117 {
    //层序遍历
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        //层序遍历所用队列
        Deque<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            while (count > 0) {
                Node poll = queue.poll();
                if (count == 1) {//当层序遍历到这一层的最后一个元素,让这个元素的next为null
                    poll.next = null;
                } else {
                    poll.next = queue.peek();//正常将层序遍历的左子树next指向右子树
                }
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
                count--;
            }
        }
        return root;
    }


    //迭代模拟,把每一层当作一个链表链接
    //dummy记录每一层链表的头部,通过对pre的移动对链表操作
    public Node connect2(Node root) {
        if (root == null) {
            return null;
        }
        Node curr = root;
        while (curr != null) {
            Node dummy = new Node(-1);//这个是假节点,作用是指向下一行的链表头部
            Node pre = dummy;//操作下一行的链表指向
            while (curr != null) {
                //1.尝试链接,,检查左孩子是否为空
                //2.如果不为空,就让pre指向左孩子
                //3.并让pre右移动
                if (curr.left != null) {
                    pre.next = curr.left;
                    pre = pre.next;
                }
                //同上
                if (curr.right != null) {
                    pre.next = curr.right;
                    pre = pre.next;
                }
                //4.让当前节点curr顺着`链表`往后走
                curr = curr.next;
            }
            //5.让当前节点指向下一行的链表头部
            curr = dummy.next;
        }
        return root;
    }
}


