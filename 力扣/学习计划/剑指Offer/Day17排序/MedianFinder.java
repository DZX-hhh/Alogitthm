package 力扣.学习计划.剑指Offer.Day17排序;


import java.util.PriorityQueue;

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

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */