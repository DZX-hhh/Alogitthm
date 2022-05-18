package LeetCode.周赛.Game281;

import LeetCode.工具类.ListNode;

public class Solution {
    /**
     * T1
     *
     * @param num
     * @return
     */
    public int countEven(int num) {
        int count = 0;
        for (int i = 1; i <= num; i++) {
            int t = i;
            int sum = 0;
            while (t > 0) {
                sum += t % 10;
                t /= 10;
            }
            if (sum % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    /**
     * T2
     *
     * @param head
     * @return
     */
    public ListNode mergeNodes(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        if (head == null) return null;
        while (fast != null) {
            if (fast.val == 0) {
                ListNode temp = fast;
                temp = temp.next;
                int sum = 0;
                while (temp != null && temp.val != 0) {
                    sum += temp.val;
                    temp.val = 0;
                    temp = temp.next;
                }
                slow.val = sum;
                slow = slow.next;
                fast = temp;
            } else {
                fast = fast.next;
            }

        }
        ListNode a = head;
        while (a.next != null) {
            if (a.next.val == 0) {
                a.next = null;
                break;
            }
            a = a.next;
        }
        return head;
    }


    /**
     * T3
     *
     * @param s
     * @param repeatLimit
     * @return
     */
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] arr = new int[26];
        //记录每个字母的个数
        for (char c : s.toCharArray()) {
            arr[c - 'a']++;
        }
        StringBuffer sb = new StringBuffer();
        //从后往前遍历,也就是从z,,,a的顺序
        //这里i表示a倒数第i个26英文字母
        for (int i = arr.length - 1; i >= 0; i--) {
            int limit = repeatLimit;
            //第一大的字母有剩余并且尚未超过限制数
            while (arr[i] > 0 && limit > 0) {
                arr[i]--;
                limit--;
                sb.append((char) (i + 'a'));
                //当达到限制,并且这个字母后面还有剩余,需要让下一个不同的字母顶替
                if (limit <= 0 && arr[i] > 0) {
                    for (int j = i - 1; j >= 0; j--) {
                        if (arr[j] > 0) {//下一字母有剩余就顶替
                            arr[j]--;
                            sb.append((char) (j + 'a'));
                            limit = repeatLimit;
                            break;
                        }
                    }
                }
            }
        }
        return String.valueOf(sb);
    }
}
