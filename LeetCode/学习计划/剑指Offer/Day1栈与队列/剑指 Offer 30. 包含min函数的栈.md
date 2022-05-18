#### [剑指 Offer 30. 包含min函数的栈](https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/)

难度简单327

定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。

**示例:**

```
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.min();   --> 返回 -3.
minStack.pop();
minStack.top();      --> 返回 0.
minStack.min();   --> 返回 -2.
```

**提示：**

1. 各函数的调用总次数不超过 20000 次

注意：本题与主站 155 题相同：https://leetcode-cn.com/problems/min-stack/

**辅助最小栈**

```java
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
```



