#### [剑指 Offer 59 - I. 滑动窗口的最大值](https://leetcode.cn/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/)

难度困难436收藏分享切换为英文接收动态反馈

给定一个数组 `nums` 和滑动窗口的大小 `k`，请找出所有滑动窗口里的最大值。

**示例:**

```
输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
输出: [3,3,5,5,6,7] 
解释: 

  滑动窗口的位置                最大值
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
```

**提示：**

- `1 <= nums.length <= 105`
- `-104 <= nums[i] <= 104`
- `1 <= k <= nums.length`

你可以假设 *k* 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。

注意：本题与主站 239 题相同：https://leetcode-cn.com/problems/sliding-window-maximum/

#### 思路

> `单调队列`:O(1)时间求某个区间的最大值

#### 单调队列

```java
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
```

#### Code

```java
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
```