package LeetCode.学习计划.Top100.easy.Soluion234;

import LeetCode.工具类.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for singly-linked list.
 * public class Leetcode.LeetcodeTool.ListNode {
 * int val;
 * Leetcode.LeetcodeTool.ListNode next;
 * Leetcode.LeetcodeTool.ListNode() {}
 * Leetcode.LeetcodeTool.ListNode(int val) { this.val = val; }
 * Leetcode.LeetcodeTool.ListNode(int val, Leetcode.LeetcodeTool.ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Solution2 {
    static int[] test = {1, 2, 2, 1};
    static ListNode head = ListNode.array2LinkedNode(test);

    public static boolean isPalindrome(ListNode head) {
        /*
         * 以链表的形式,使用链表的get(index)方法得到对应的值
         */
        boolean flag = true;
        ListNode currentNode = head;
        List<ListNode> list = new ArrayList<>();
        //复制链表
        while (currentNode != null) {
            list.add(currentNode);
            currentNode = currentNode.next;
        }
        //获取最后一个节点下标
        int lastNodeIndex = list.size() - 1;
        int beginNodeIndex = 0;
        //判断后面的指针在前面的指针后面,二者灭有重合
        while (lastNodeIndex >= beginNodeIndex) {
            if (list.get(beginNodeIndex).val != list.get(lastNodeIndex).val) {
                return false;
            }
            //指针移动,相互靠近
            lastNodeIndex--;
            beginNodeIndex++;
        }
        return flag;

    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(head));
    }
}