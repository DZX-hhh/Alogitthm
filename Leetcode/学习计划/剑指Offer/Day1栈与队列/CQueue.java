package LeetCode.学习计划.剑指Offer.Day1栈与队列;

import java.util.ArrayDeque;
import java.util.Deque;

public class CQueue {

    Deque<Integer> stackHead = new ArrayDeque<>();
    Deque<Integer> stackTail = new ArrayDeque<>();

    public CQueue() {

    }

    public void appendTail(int value) {
        stackTail.push(value);
    }

    /**
     * @return 弹出栈顶元素实现队列出队
     * 1:判断栈是否为空
     * 2:如果为空,就将stackTail里面的元素依次取出来即可,顺序正好是最先加入的最先出stackHead
     */
    public int deleteHead() {
        if (stackHead.size() + stackTail.size() == 0) return -1;
        if (stackHead.isEmpty()) {
            while (!stackTail.isEmpty()) {
                stackHead.push(stackTail.pop());
            }
        }
        return stackHead.pop();
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */