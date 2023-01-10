package LeetCode.学习计划.Top100.easy.Soluion234;

import LeetCode.工具类.ListNode;

/**
 * 快慢指针方法:
 * 1,快指针为慢指针的两倍速度移动,即快指针一下移动两个,慢指针一下移动一个
 * 从慢指针得到后半段链表
 * 2.反转后半段链表,,代码参考206
 * 3.比较是否为回文数
 * 4.恢复链表,,就是让左半链表的末尾节点next指针指向右半链表二次反转之后的头节点
 * 5.返回结果
 */
public class Solution3 {
    static int[] test = {1, 2};
    static ListNode head = ListNode.array2LinkedNode(test);


    //开始比较
    public boolean isPalindrome(ListNode head) {

        ListNode leftHalfEndNode = leftHalfEnd(head);//左半部分结束节点
        ListNode rightHalfBeginNode = reverse(leftHalfEndNode.next);//右半部分开始节点,为反转后的节点
        //二者可以比较了


        ListNode left = leftHalfEndNode;
        ListNode right = rightHalfBeginNode;

        if (head == null || head.next == null) {
            return true;
        }
        while (right != null) {
            //知道右半部分链表便利结束
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        //恢复链表,,就是让左半链表的末尾节点next指针指向右半链表二次反转之后的头节点
        leftHalfEndNode.next = reverse(rightHalfBeginNode);
        return true;
    }


    /**
     * 206反转链表
     * 主要就是每个节点的next指针指向前面一个节点
     *
     * @param head
     * @return
     */
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode tempNext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tempNext;
        }
        return prev;
    }

    /**
     * 快慢指针,找到中间节点
     */
    public ListNode leftHalfEnd(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            //当快指针害可以移动时
            fast = fast.next.next;//一下往后移动移动两个
            slow = slow.next;
        }
        return slow;//返回慢指针,也就是中间指针
    }
}
