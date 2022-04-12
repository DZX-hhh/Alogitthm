package Leetcode.Study.单调队列;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class MonotonicQueue {
    // 双链表，支持头部和尾部增删元素
    private LinkedList<Integer> q;

    public MonotonicQueue() {
        q = new LinkedList<>();
    }

    void push(int num) {
        while (q.getFirst() < num) {
            q.pollLast();//删除更小的元素,使之单调
        }
        q.addLast(num);
    }

    void pop(int num) {
        if (num == q.getFirst()) {
            q.pollFirst();
        }
    }

    int max() {
        return q.getFirst();
    }
}

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue window = new MonotonicQueue();//Study.单调队列
        List<Integer> res = new ArrayList<>();//数组型链表
        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                window.push(nums[i]);
            } else {
                window.push(nums[i]);
                res.add(window.max());
                window.pop(nums[i - k + 1]);
            }
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

    String removeDuplicateLetters(String s) {
        Deque<Character> stack = new LinkedList<>();
        int[] count = new int[256];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }
        boolean[] instack = new boolean[256];
        for (char c : s.toCharArray()) {
            if (instack[c]) {
                break;
            }
            count[stack.peek()]--;
            while (!stack.isEmpty() && stack.peek() > c) {
                if (count[stack.peek()] == 0) {
                    break;
                }
                instack[stack.pop()] = false;
            }
            stack.push(c);
        }
        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}