package Leetcode.Top100.easy.Solution155;

import java.util.Deque;
import java.util.LinkedList;

public class MinStack3 {

    private Deque<Long> minstack;
    long min;

    public MinStack3() {
        minstack = new LinkedList<Long>();
    }

    public void push(int val) {
        if (minstack.isEmpty()) {
            min = (long) val;//当栈为空,最小值为val
            minstack.push(0L);//如果栈为空,保存0L,类型
            return;
        }
        minstack.push((long) val - min);//保存差值,当前val和当前最小值min的差值
        min = Math.min(min, (long) val);//更新最小值
    }

    public void pop() {
        Long pop = minstack.pop();//除去栈顶元素
        if (pop >= 0) {//栈顶元素大于0,说明原来的val-min>=0,也就是最小值任然是min,不需要更新
            return;
        }
        //栈顶元素<0,说明需要更新min
        long val = min;//先保存栈顶元素对应的min,也就是val-min<0,min值为已经弹出的pop对应的val
        min = val - pop;//已经弹出的val-(已经弹出的val-这个val入栈前未更新的min)
        //min=val-(val-min)从而达到min值的更新
    }

    public int top() {
        if (minstack.peek() < 0) {
            return (int) min;//如果val<min,那么刚进入栈的val就是min,目标需要返回的就是val
        }
        return (int) (minstack.peek() + min);//将栈顶元素加上最小值min
    }

    public int getMin() {
        return (int) min;//目前已经保存了min值
    }
}
