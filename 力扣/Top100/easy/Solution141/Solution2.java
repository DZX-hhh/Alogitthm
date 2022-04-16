package 力扣.Top100.easy.Solution141;

import 力扣.工具类.ListNode;

/**
 * 判断链表是否有环
 * 使用快慢指针
 * 快指针会在环里不断循环,最终与慢指针相遇,二者相等
 */

public class Solution2 {
    /**
     * 采用快慢指针相互追逐的方法
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head.next == null) {
            return false;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != slow) {
            if (fast.next.next == null || fast.next == null) {
                return false;
            }
            fast = fast.next.next;//快指针
            slow = slow.next;//慢指针
        }
        return true;
    }
}
