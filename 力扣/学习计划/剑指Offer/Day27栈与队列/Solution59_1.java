package 力扣.学习计划.剑指Offer.Day27栈与队列;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution59 {
    /**
     * 求某个区间的最大值,一般使用单调队列解决
     *
     * @param nums 数组
     * @param k    滑动窗口的大小
     * @return 所有滑动窗口的最大值
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        monoQueue queue = new monoQueue();
        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                queue.push(nums[i]);
            } else {
                queue.push(nums[i]);
                list.add(queue.getMax());
                queue.pop(nums[i - k + 1]);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}

class monoQueue {
    //单调队列,内部保持单调递减
    LinkedList<Integer> queue;

    public monoQueue() {
        queue = new LinkedList<>();
    }

    /**
     * @param num 新加人的元素,维护单调队列的递减性
     */
    public void push(int num) {
        while (!queue.isEmpty() && num > queue.getLast()) {//让比num小的元素去除
            queue.removeLast();
        }
        queue.addLast(num);
    }

    /**
     * @param num 窗口中需要弹出的元素,当这个元素等于当前窗口最大值,那么需要重新更新最大值,否则的话不需要对单调队列做修改
     */
    public void pop(int num) {
        if (num == queue.getFirst()) {
            queue.pollFirst();
        }
    }

    public int getMax() {
        return queue.getFirst();
    }
}
