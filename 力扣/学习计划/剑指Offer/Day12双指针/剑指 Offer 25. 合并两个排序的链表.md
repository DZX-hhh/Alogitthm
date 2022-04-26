#### [剑指 Offer 25. 合并两个排序的链表](https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/)

难度简单239收藏分享切换为英文接收动态反馈

输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。

**示例1：**

```
输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
```

**限制：**

```
0 <= 链表长度 <= 1000
```

注意：本题与主站 21 题相同：https://leetcode-cn.com/problems/merge-two-sorted-lists/

**迭代**

```java
public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null) return l2;
    if (l2 == null) return l1;
    ListNode dummy = new ListNode(-1);
    ListNode curr = dummy;
    while (l1 != null && l2 != null) {
        curr.next = l1.val < l2.val ? l1 : l2;
        curr = curr.next;
        if (l1.val < l2.val) {
            l1 = l1.next;
        } else {
            l2 = l2.next;
        }
    }
    if (l1 == null) {
        curr.next = l2;
    }
    if (l2 == null) {
        curr.next = l1;
    }
    return dummy.next;
}
```

**递归**

```java
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
```