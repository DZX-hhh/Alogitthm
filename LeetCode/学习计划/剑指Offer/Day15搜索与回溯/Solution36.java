package LeetCode.学习计划.剑指Offer.Day15搜索与回溯;

import LeetCode.知识点.二叉树.Node;

public class Solution36 {

    Node head, pre;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        //1.构造有序的双向链表
        dfs(root);
        //2.构造循环链表
        pre.right = head;
        head.left = pre;
        return head;
    }

    /*
        二叉搜索树-->排序的双向循环链表
            1.排序:中序遍历
            2.双向:pre指针(更小的元素)和curr指针(更大的元素)
                -->pre.right=curr;curr.left=pre;
            3.循环:head指针(最小的元素)和tail指针(最大的元素)
                -->head.left=tail;tail.right=head;
     */
    private void dfs(Node curr) {
        if (curr == null) {//递归到最后节点退出
            return;
        }
        dfs(curr.left);
        if (pre == null) {//如果pre为空,那就说明当前节点的左节点为空,访问的是头节点,设置头节点
            head = curr;
        } else {//如果pre不为空,可以pre.right=curr,,而上面pre为空,无法设置pre的指针
            pre.right = curr;
        }
        curr.left = pre;//这里与上面的pre是否为空无关,,中序遍历curr.left=pre;
        pre = curr;//让当前节点开始往后走,,所以需要保存curr,让curr成为后面的前驱节点
        dfs(curr.right);
    }
}
