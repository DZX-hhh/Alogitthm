package Leetcode.LeetcodeStudy.随机算法.数据流中位数;

import java.util.PriorityQueue;

/**
 * 数据流中位数
 */
public class MedianFinder {//数据流的中位数

    PriorityQueue<Integer> large;
    PriorityQueue<Integer> small;

    public MedianFinder() {
        //小根堆,从根节点往下递增,呈现梯形
        large = new PriorityQueue<>();
        //大根堆,从根节点往下递减,呈现倒三角形
        small = new PriorityQueue<>(
                (num1, num2) -> {
                    return num2 - num1;
                }
        );
    }

    /**
     * 需要维护两个优先队列
     * 1.两个堆中的元素之差不能超过 1
     * 2.small倒三角最大元素小于large梯形最小元素
     *
     * @param num
     */
    public void addNum(int num) {
        if (small.size() >= large.size()) {
            //small元素更多,最终是large增加元素,但是增加的元素需要是small最大元素,也就是队头元素,
            // 这样就维护了large最小元素大于small最大元素
            small.offer(num);
            large.offer(small.poll());
        } else {
            large.offer(num);
            small.offer(large.poll());
        }
    }

    public double findMedian() {
        //如果两个优先队列大小不等,返回元素个数更大的顶部元素
        if (large.size() > small.size()) {
            return large.peek();
        } else if (small.size() > large.size()) {
            return small.peek();
        } else {
            return (small.peek() + large.peek()) / 2.0;
        }
    }
}
