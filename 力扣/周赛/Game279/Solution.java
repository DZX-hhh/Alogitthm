package 力扣.周赛.Game279;

import java.util.PriorityQueue;

public class Solution {
    public int[] sortEvenOdd(int[] nums) {
        PriorityQueue<Integer> queue1 = new PriorityQueue<>();
        PriorityQueue<Integer> queue2 = new PriorityQueue<>(
                (a, b) -> {
                    return b - a;
                }
        );
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                queue1.offer(nums[i]);
            } else {
                queue2.offer(nums[i]);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                nums[i] = queue1.poll();
            } else {
                nums[i] = queue2.poll();
            }
        }
        return nums;
    }


    public long smallestNumber(long num) {
        if (num == 0) {
            return 0;
        }
        int count = 0;
        if (num > 0) {
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            String s = String.valueOf(num);
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) - '0' == 0) {
                    count++;
                } else {
                    queue.offer(s.charAt(i) - '0');
                }
            }
            int t = count;
            String s1 = String.valueOf(queue.poll());
            while (count > 0) {
                s1 += 0;
                count--;
            }
            for (int i = t + 1; i < s.length(); i++) {
                s1 += queue.poll();
            }
            return Long.parseLong(s1);
        } else {
            PriorityQueue<Integer> queue = new PriorityQueue<>(
                    (a, b) -> {
                        return b - a;
                    }
            );
            String s = String.valueOf(num);
            String res = "-";
            for (int i = 1; i < s.length(); i++) {
                queue.offer(s.charAt(i) - '0');
            }
            for (int i = 1; i < s.length(); i++) {
                res += queue.poll();
            }
            return Long.parseLong(res);
        }
    }
}

/**
 * 懒惰标记法:懒惰标记法:刚开始并不改变数组,记录是否反转状态,当需要用的时候再操作
 */
class Bitset {
    int count_1;
    boolean isReversed;
    int[] bits;
    int size;

    public Bitset(int size) {
        count_1 = 0;
        isReversed = false;
        bits = new int[size];
        this.size = size;
    }

    public void fix(int idx) {
        if (isReversed) {
            if (bits[idx] == 1) {
                bits[idx] = 0;
                count_1++;
            }
        } else if (bits[idx] == 0) {
            bits[idx] = 1;
            count_1++;
        }
    }

    public void unfix(int idx) {
        if (isReversed) {
            if (bits[idx] == 0) {
                bits[idx] = 1;
                count_1--;
            }
        } else if (bits[idx] == 1) {
            bits[idx] = 0;
            count_1--;
        }
    }

    /**
     * 反转状态
     */
    public void flip() {
        isReversed = !isReversed;
        count_1 = size - count_1;
    }

    public boolean all() {
        return size == count_1;
    }

    public boolean one() {
        return count_1 > 0;
    }

    public int count() {
        return count_1;
    }

    public String toString() {
        StringBuffer res = new StringBuffer();
        if (isReversed) {
            for (int bit : bits) res.append(bit ^ 1);
        } else {
            for (int bit : bits) res.append(bit);
        }
        return String.valueOf(res);
    }
}

/**
 * Your Bitset object will be instantiated and called as such:
 * Bitset obj = new Bitset(size);
 * obj.fix(idx);
 * obj.unfix(idx);
 * obj.flip();
 * boolean param_4 = obj.all();
 * boolean param_5 = obj.one();
 * int param_6 = obj.count();
 * String param_7 = obj.toString();
 */
