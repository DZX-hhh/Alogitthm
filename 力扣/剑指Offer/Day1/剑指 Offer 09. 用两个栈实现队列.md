#### [剑指 Offer 09. 用两个栈实现队列](https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/)

难度简单512

用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 `appendTail` 和 `deleteHead` ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，`deleteHead` 操作返回 -1 )

**示例 1：**

```
输入：
["CQueue","appendTail","deleteHead","deleteHead"]
[[],[3],[],[]]
输出：[null,null,3,-1]
```

**示例 2：**

```
输入：
["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
[[],[],[5],[2],[],[]]
输出：[null,-1,null,null,5,2]
```

**提示：**

- `1 <= values <= 10000`
- `最多会对 appendTail、deleteHead 进行 10000 次调用`

> 前栈为空,后栈取
>
> 二者为空,返-1

```java
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
```

