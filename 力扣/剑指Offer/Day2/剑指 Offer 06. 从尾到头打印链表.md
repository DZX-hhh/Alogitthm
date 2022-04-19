#### [剑指 Offer 06. 从尾到头打印链表](https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/)

难度简单277

输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。

**示例 1：**

```
输入：head = [1,3,2]
输出：[2,3,1]
```

**限制：**

```
0 <= 链表长度 <= 10000
```

**递归**

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] reversePrint(ListNode head) {
        ListNode res = reverse(head);
        int[] resArr = new int[size];
        for (int i = 0; i < size; i++) {
            resArr[i] = res.val;
            res = res.next;
        }
        return resArr;
    }

    int size = 0;

    public ListNode reverse(ListNode head) {
        if (head == null) return null;
        size++;
        if (head.next == null) return head;
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}
```

**迭代**

```java
//迭代+链表反转
public int[]reversePrint(ListNode head){
        LinkedList<Integer> list=new LinkedList<>();
        ListNode prev=null;
        ListNode curr=head;
        int size=0;
        while(curr!=null){
        ListNode next=curr.next;
        curr.next=prev;
        prev=curr;
        curr=next;
        size++;
        //list.add(curr.val);
        }
        int[]res=new int[size];
        int i=0;
        while(prev!=null){
        res[i++]=prev.val;
        prev=prev.next;
        }
        return res;
        }
```