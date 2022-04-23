package 力扣.学习计划.Top100.easy.Solution141;

import 力扣.工具类.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 判断是否有环
 * 使用hash表,保存访问过的节点,如果再次访问说明存在环,反之,没有
 */
public class Solution1 {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();//新建hashSet表
        while (head != null) {//遍历链表
            if (!set.add(head)) {
                //如果添加失败
                //说明已经访问过这个节点,存在环,返回true
                return true;
            }
            head = head.next;
        }
        return false;
    }
}
