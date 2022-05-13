#### [剑指 Offer 59 - II. 队列的最大值](https://leetcode.cn/problems/dui-lie-de-zui-da-zhi-lcof/)

难度中等365收藏分享切换为英文接收动态反馈

请定义一个队列并实现函数 `max_value` 得到队列里的最大值，要求函数`max_value`、`push_back` 和 `pop_front` 的**均摊**时间复杂度都是O(1)。

若队列为空，`pop_front` 和 `max_value` 需要返回 -1

**示例 1：**

```
输入: 
["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
[[],[1],[2],[],[],[]]
输出: [null,null,null,2,1,2]
```

**示例 2：**

```
输入: 
["MaxQueue","pop_front","max_value"]
[[],[],[]]
输出: [null,-1,-1]
```

**限制：**

- `1 <= push_back,pop_front,max_value的总操作数 <= 10000`
- `1 <= value <= 10^5`

#### 思路

> 单调递减队列+一个辅助队列

#### Code

```java
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
```