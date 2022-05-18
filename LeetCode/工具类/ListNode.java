package LeetCode.工具类;

public class ListNode {
    public int val;
    public ListNode next;
    ListNode (int val) {
        this.val = val;
    }

    /**
     * 按照数组的输出形式输出
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode pointer = this;
        while (pointer != null){
            sb.append(pointer.val).append(",");
            pointer = pointer.next;
        }
        return sb.substring(0, sb.length() - 1);
    }

    /**
     * 数组转链表
     */
    public static ListNode array2LinkedNode (int[] data){
        if (data.length < 1){
            return new ListNode(0);
        } else {
            ListNode head = new ListNode(data[0]);
            ListNode pointer = head;
            for (int i = 1; i < data.length; i++) {
                pointer.next = new ListNode(data[i]);
                pointer = pointer.next;
            }
            return head;
        }
    }
}

