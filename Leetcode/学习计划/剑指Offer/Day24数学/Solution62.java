package LeetCode.学习计划.剑指Offer.Day24数学;

import java.util.ArrayList;

public class Solution62 {
    /*
        队列模拟
     */
    public int lastRemaining(int n, int m) {
        ArrayList<Integer> queue = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            queue.add(i);
        }
        int idx = 0;
        while (n > 1) {
            idx = (idx + m - 1) % n;//这里循环模拟,删除往后第m个元素%n
            queue.remove(idx);
            n--;
        }
        return queue.get(0);
    }

    /*
        约瑟夫环
     */
    public int lastRemaining2(int n, int m) {
        if (n <= 1) {
            return 0;
        }
        int res = (lastRemaining(n - 1, m) + m) % n;
        return res;
    }
}
