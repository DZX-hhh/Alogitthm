package 力扣.学习计划.剑指Offer.Day12双指针;

import 力扣.工具类.ListNode;

import java.util.HashSet;

public class Solution52 {
    /**
     * 不断前进,走完了路,如果对方还在走
     * 那么就去走他开始的路去追赶他吧
     * 直至都为空,或者相遇
     */

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;//只要有一个为空 ,那么就全为空
        ListNode currA = headA, currB = headB;
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

    /**
     * 用set将headA的节点记录,,遍历headB
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode currA = headA, currB = headB;
        HashSet<ListNode> set = new HashSet<>();
        while (currA != null) {
            set.add(currA);
            currA = currA.next;
        }
        while (currB != null) {
            if (!set.add(currB)) {
                return currB;
            }
            currB = currB.next;
        }
        return null;
    }
}
