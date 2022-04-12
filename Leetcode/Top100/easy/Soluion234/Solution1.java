package Leetcode.Top100.easy.Soluion234;

import Leetcode.Tool.ListNode;

import java.util.Stack;


public class Solution1 {
    static int[] test = {1, 2};
    static ListNode head = ListNode.array2LinkedNode(test);

    public static boolean isPalindrome(ListNode head) {
        /*
         * 以出栈入栈的方式,指定指针链表的元素
         */
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode node = head;
        boolean flag = true;
        while (node!= null) {//入栈
            stack.push(node);
            node = node.next;
        }
        while (!stack.isEmpty()) {//出栈直到为空
            if (stack.pop().val != head.val) {
                //如果弹出的元素不等于链表顺序的元素,那么返回false
                flag = false;
            }
            head = head.next;
        }
        return flag;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(head));
    }
}