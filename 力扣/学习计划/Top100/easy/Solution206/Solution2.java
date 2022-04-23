package 力扣.学习计划.Top100.easy.Solution206;

import 力扣.工具类.ListNode;


public class Solution2 {
    static int[] test = {1, 2};
    static ListNode head = ListNode.array2LinkedNode(test);

    /**
     * 反转链表
     * 核心思想:将各个节点的next指针指向它前面的节点
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {//主要目的是将各个节点的next指针指向它前面的节点
            ListNode tempNext = curr.next;//先暂时保存当前节点的下一节点
            curr.next = prev;//将当前节点的next指针指向它前面的节点
            prev = curr;//将prev节点移动到当前位置,继续成为前一节点
            curr = tempNext;//将保留的下一节点赋值给当前节点,也就是移动到下一位置,然后再作为当前的位置
        }
        return prev;//因为curr在循环结束后一定为null,并且循环中已经反转了链表,因此此时的头节点必然是prev
    }

    public static void main(String[] args) {
        System.out.println(head);
    }
}
