package 力扣.学习计划.算法.Day3双指针;

import 力扣.工具类.ListNode;

public class Soluton82 {
    /**
     * @param head
     * @return 递归, , 主要是区别头部能不能用, 如果重复了, 那么就无法继续用下去了, , 递归head=函数(next)
     * 反之,head.next=函数(next)
     */
    public ListNode deleteDuplicates(ListNode head) {
        //base case
        if (head == null || head.next == null) return head;

        //递归
        ListNode next = head.next;
        //如果是这种情况
        //      1 --> 1 --> 1 --> 2 --> 3
        //     head  next
        //1.则需要移动next直到出现与当前head.value不相等的情况（含null）
        //2.并且此时的head已经不能要了，因为已经head是重复的节点
        //--------------else-------------
        //      1 --> 2 --> 3
        //     head  next
        //3.如果没有出现1的情况，则递归返回的节点就作为head的子节点
        if (next.val == head.val) {
            //1
            while (next != null && head.val == next.val) {
                next = next.next;
            }
            //2
            head = deleteDuplicates(next);
        } else {
            //3
            head.next = deleteDuplicates(next);
        }
        return head;
    }
}

/**
 * 迭代版
 * <p>
 * public ListNode deleteDuplicates2(ListNode head) {
 * ListNode dummyHead = new ListNode(-1, head);//也就是在head前加一个新节点
 * ListNode pre = dummyHead, cur = pre.next;//curr=head;
 * while (cur != null) {
 * ListNode next = cur.next;
 * while (next != null && cur.val == next.val) {//去除开头重复的现象
 * next = next.next;
 * }
 * if (next != cur.next) {
 * //next发生移动过,head到next之间有 重复情况
 * //将pre.next=next,跳过了重复元素
 * pre.next = next;
 * cur = next;
 * } else {
 * //next没有移动过,,pre和cur向后移动一位
 * pre = cur;
 * cur = next;
 * }
 * }
 * return dummyHead.next;//返回头节点
 * }
 * }
 */