package LeetCode.学习计划.剑指Offer.Day27栈与队列;

import java.util.LinkedList;
import java.util.Queue;

public class Solution59_2 {

}

/**
 * 单调队列,让队列保持递减的规律,随时可以取出最大值
 */
class MaxQueue {
    LinkedList<Integer> Maxqueue;
    Queue<Integer> queue;

    public MaxQueue() {
        Maxqueue = new LinkedList<>();//单调队列
        queue = new LinkedList<>();//辅助队列
    }

    public int max_value() {
        return Maxqueue.isEmpty() ? -1 : Maxqueue.getFirst();
    }

    public void push_back(int value) {
        queue.offer(value);
        while (!Maxqueue.isEmpty() && Maxqueue.getLast() < value) {//保持单调递减的规律
            Maxqueue.pollLast();
        }
        Maxqueue.addLast(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        } else if (queue.peek().equals(Maxqueue.getFirst())) {
            Maxqueue.pollFirst();
        }
        return queue.poll();
    }
}

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */