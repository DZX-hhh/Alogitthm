package 力扣.学习计划.Top100.easy.Solution155;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class MinStack {

    private Stack<Integer> stack = new Stack<>();
    private List<Integer> list = new ArrayList<Integer>();
    int index = -1;//记录list元素的索引

    public MinStack() {
    }

    public void push(int val) {
        list.add(val);

    }

    public void pop() {
        list.remove(list.size() - 1);//移除最后一个元素
    }

    public int top() {
        return list.get(list.size() - 1);//获取最后一个元素
    }

    public int getMin() {
        List<Integer> templist = new ArrayList<>(list);
        Collections.sort(templist);
        return templist.get(0);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */