package Leetcode.Top100.easy.Solution160;

import Leetcode.Tool.ListNode;

public class Solution2 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode currA = headA;
        ListNode currB = headB;

        while (currA != null && currB != null) {
            if (currA == currB) {
                return currA;
            }
            currA = currA.next;
            currB = currB.next;
            if (currA == null && currB != null) {
                currA = headB;
            }
            if (currB == null && currA != null) {
                currB = headA;
            }
        }
        return null;
    }
}
