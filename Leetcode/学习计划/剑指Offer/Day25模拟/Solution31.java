package LeetCode.学习计划.剑指Offer.Day25模拟;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque<>();
        int popIndex = 0;
        for (int pushNum : pushed) {
            stack.push(pushNum);//入栈 num
            while (!stack.isEmpty() && popped[popIndex] == stack.peek()) {//循环判断和出栈
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }
}
