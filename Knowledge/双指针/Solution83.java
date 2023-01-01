package LeetCode.知识点.双指针;

import LeetCode.工具类.ListNode;

public class Solution83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            if (fast.val != slow.val) {//当出现不重复的值
                slow.next = fast;//指向不重复的节点
                slow = slow.next;
            }
            fast = fast.next;
        }
        return head;
    }

    public void moveZeroes(int[] nums) {
        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        for (int i = slow; i < nums.length; i++) {
            nums[slow] = 0;
        }
    }
}
