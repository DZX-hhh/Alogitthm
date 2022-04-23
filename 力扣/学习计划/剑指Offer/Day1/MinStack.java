package 力扣.学习计划.剑指Offer.Day1;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {
    Deque<Integer> stack = new ArrayDeque<>();
    //辅助最小栈-----每一次都是push当前的最小值
    Deque<Integer> minstack = new ArrayDeque<>();

    public MinStack() {
        minstack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        if (x < minstack.peek()) {
            minstack.push(x);//记录当前最小值
        } else {
            minstack.push(minstack.peek());
        }
        stack.push(x);
    }

    public void pop() {
        minstack.pop();
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minstack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
