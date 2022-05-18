#### [剑指 Offer 41. 数据流中的中位数](https://leetcode.cn/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof/)

难度困难310收藏分享切换为英文接收动态反馈

如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。

例如，

[2,3,4] 的中位数是 3

[2,3] 的中位数是 (2 + 3) / 2 = 2.5

设计一个支持以下两种操作的数据结构：

- void addNum(int num) - 从数据流中添加一个整数到数据结构中。
- double findMedian() - 返回目前所有元素的中位数。

**示例 1：**

```
输入：
["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
[[],[1],[2],[],[3],[]]
输出：[null,null,null,1.50000,null,2.00000]
```

**示例 2：**

```
输入：
["MedianFinder","addNum","findMedian","addNum","findMedian"]
[[],[2],[],[3],[]]
输出：[null,null,2.00000,null,2.50000]
```

**限制：**

- 最多会对 `addNum、findMedian` 进行 `50000` 次调用。

注意：本题与主站 295 题相同：https://leetcode-cn.com/problems/find-median-from-data-stream/

**思路**:

* 两个优先队列:一个大根堆(递减)small,一个小根堆(递增)large
* 维持大根堆最大元素small<小根堆最小元素large
* 并且那个队列个数多,往那个队列插入元素,并再将多的队列poll给少的队列

```java
/*
    数据流中位数,数据量过多,应该想象成两个梯形,一个小根堆,一个大根堆
    1.小根堆的最小值(也就是堆顶元素) > 大根堆的最大值(也就是对顶元素)
    2.两个根堆差值小于等于1,否则增加数字在更少的堆加
*/
public class MedianFinder {
    //1.建立大小根堆
    PriorityQueue<Integer> big = new PriorityQueue<>();
    PriorityQueue<Integer> small = new PriorityQueue<>((a, b) -> {
        return b - a;
    });


    public MedianFinder() {

    }

    public void addNum(int num) {
        if (big.size() >= small.size()) {
            big.offer(num);
            small.offer(big.poll());
        } else {
            small.offer(num);
            big.offer(small.poll());
        }
    }

    public double findMedian() {
        if (small.size() == big.size()) {
            return (small.peek() + big.peek()) / 2.0;
        } else {
            return small.size() > big.size() ? small.peek() : big.peek();
        }
    }
}
```