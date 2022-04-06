package Leetcode.Top100.easy.Solution206;

import Leetcode.LeetcodeTool.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Study.双指针
 */
public class Solution1 {

    static int[] test = {1, 2};
    static ListNode head = ListNode.array2LinkedNode(test);

    /**
     * 反转链表
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode currentNode = head;
        List<ListNode> list = new ArrayList<>();
        while (currentNode != null) {//复制链表
            list.add(currentNode);
            currentNode = currentNode.next;
        }
        int index = list.size() - 1;
        int headIndex = 0;
        while (index >= 0) {
            head = list.get(index);
            head = head.next;
            index--;
        }
        return head;
    }

    public static void main(String[] args) {
        System.out.println(head);
    }
}
