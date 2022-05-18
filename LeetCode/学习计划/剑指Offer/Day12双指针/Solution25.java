package LeetCode.学习计划.剑指Offer.Day12双指针;

import LeetCode.工具类.ListNode;

public class Solution25 {
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        if (l1 == null) return l2;
//        if (l2 == null) return l1;
//        ListNode dummy = new ListNode(-1);
//        ListNode curr = dummy;
//        while (l1 != null && l2 != null) {
//            curr.next = l1.val < l2.val ? l1 : l2;
//            curr = curr.next;
//            if (l1.val < l2.val) {
//                l1 = l1.next;
//            } else {
//                l2 = l2.next;
//            }
//        }
//        if (l1 == null) {
//            curr.next = l2;
//        }
//        if (l2 == null) {
//            curr.next = l1;
//        }
//        return dummy.next;
//    }

    /**
     * 递归调用
     */
    public ListNode mergeTwoList(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode head = l1.val < l2.val ? l1 : l2;
        head.next = mergeTwoList(l1.val < l2.val ? l1.next : l2.next, l1.val < l2.val ? l2 : l1);
        return head;
    }
}
