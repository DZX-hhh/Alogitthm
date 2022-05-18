package LeetCode.学习计划.Top100.easy.Solution160;

import LeetCode.工具类.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Solution1 {
    /**
     * 使用HashSet的add方法,判断是否访问过这个节点
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> nodeSet = new HashSet<>();
        ListNode currA = headA;
        ListNode currB = headB;
        while (currA != null && currB != null) {
            //遍历两个链表
            if (!nodeSet.add(currA)) {
                return currA;
            } else currA = currA.next;
            if (!nodeSet.add(currB)) {
                return currB;
            } else currB = currB.next;
        }
        return null;
    }
}