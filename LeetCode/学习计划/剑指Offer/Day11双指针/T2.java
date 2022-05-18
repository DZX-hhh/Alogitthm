package LeetCode.学习计划.剑指Offer.Day11双指针;

import LeetCode.工具类.ListNode;

public class T2 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode slow = head, fast = head;
        while (k-- > 0) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
