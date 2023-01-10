package LeetCode.学习计划.剑指Offer.Day11双指针;

import LeetCode.工具类.ListNode;

public class T1 {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode curr = head, prev = null;
        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
                break;
            }
            prev = curr;
            curr = curr.next;
        }
        return head;
    }
}
