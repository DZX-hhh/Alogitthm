package Leetcode.Top100.easy.Solution155;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 辅助栈
 */
public class MinStack2 {
    //辅助栈,栈顶元素存储当前的最小元素
    private Deque<Integer> minstack = new LinkedList<>();
    private Deque<Integer> fuzustack = new LinkedList<>();//辅助栈

    public MinStack2() {
        fuzustack.push(Integer.MAX_VALUE);//
    }

    public void push(int val) {
        minstack.push(val);
        fuzustack.push(Math.min(val, fuzustack.peek()));
    }

    public void pop() {
        minstack.pop();
        fuzustack.pop();
    }

    public int top() {
        return minstack.peek();
    }

    public int getMin() {
        return fuzustack.peek();
    }
}
