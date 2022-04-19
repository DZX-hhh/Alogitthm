package 力扣.剑指Offer.Day2;

import 力扣.工具类.ListNode;

import java.util.HashMap;
import java.util.LinkedList;

public class Day2 {
    //迭代+链表反转
    public int[] reversePrint(ListNode head) {
        LinkedList<Integer> list = new LinkedList<>();
        ListNode prev = null;
        ListNode curr = head;
        int size = 0;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            size++;
            //list.add(curr.val);
        }
        int[] res = new int[size];
        int i = 0;
        while (prev != null) {
            res[i++] = prev.val;
            prev = prev.next;
        }
        return res;
    }

    //递归链表反转
    public ListNode reverse(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}


class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

class Solution {
    //迭代
    public Node copyRandomList(Node head) {
        if (head == null) return head;
        Node temp = head;
        //第一步,在每个源节点后面创建一个新节点
        //1->1'->2->2'->3->3'
        while (temp != null) {
            Node newNode = new Node(temp.val);
            newNode.next = temp.next;
            temp.next = newNode;
            temp = newNode.next;
        }
        temp = head;
        //第二步,设置新节点的随机节点,新节点的随机指针在源节点的随即指针后面一位
        while (temp != null) {
            if (temp.random != null) {
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }
        temp = head;
        Node res = new Node(-1);
        Node curr = res;
        //第三步,将两个链表分离
        while (temp != null) {
            curr.next = temp.next;//新链表
            curr = curr.next;
            temp.next = curr.next;//旧链表
            temp = temp.next;
        }
        return res.next;
    }

    //哈希表,k-源节点 v-新节点  "映射"
    public Node copyRandomList2(Node head) {
        if (head == null) return null;
        //源节点-新节点
        HashMap<Node, Node> map = new HashMap<>();
        Node temp = head;
        while (temp != null) {
            //创建新节点
            Node newNode = new Node(temp.val);
            map.put(temp, newNode);
            temp = temp.next;
        }
        temp = head;
        //设置新节点的next和random
        while (temp != null) {
            Node newNode = map.get(temp);
            //newNode是源节点对应的新节点,newNode.next是源节点的下一个
            //map.get(temp.next)是源节点的下一个对应的新节点
            if (temp.next != null) {
                newNode.next = map.get(temp.next);
            }
            //newNode的random为源节点的random对应的
            if (temp.random != null) {
                newNode.random = map.get(temp.random);
            }
            temp = temp.next;
        }

        //返回全新的头节点
        return map.get(head);
    }
}