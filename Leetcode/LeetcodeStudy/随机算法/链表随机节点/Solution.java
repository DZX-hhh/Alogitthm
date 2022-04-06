package Leetcode.LeetcodeStudy.随机算法.链表随机节点;

import java.util.Random;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {

    ListNode head;
    Random random;

    public Solution(ListNode head) {
        //构造函数
        this.head = head;
        random = new Random();
    }

    /**
     * 返回随机节点的值
     * 第i个元素有1/i的概率更新答案,否则答案不变
     * 最终算法会保证每个节点的概率都为1/n
     *
     * @return
     */
    public int getRandom() {
        int i = 1;
        int res = 0;
        ListNode currNode = head;
        while (currNode != null) {
            if (random.nextInt(i) == 0) {//如果[0,i)的i个数,随机得到为0(概率为1/i),那么更新这个数为答案
                res = currNode.val;//更新为当前节点的答案
            }
//            else {//否则答案保持不变
//                continue;
//            }
            currNode = currNode.next;
            i++;
        }
        return res;
    }
}