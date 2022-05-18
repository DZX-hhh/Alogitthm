package LeetCode.每日一题.Five.Day4;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    /*
        约瑟夫环,,队列模拟
     */
    public int findTheWinner(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {//初始化队列
            queue.add(i);
        }
        while (queue.size() != 1) {
            for (int i = 0; i < k - 1; i++) {
                queue.offer(queue.poll());
            }
            queue.poll();
        }
        return queue.peek();
    }

    /*
        递归,,看作是一个环
     */
    public int findTheWinner2(int n, int k) {
        if (n <= 1) {
            return n;
        }
        //消除一个数之后,后者重新编号之后,与前者下标相差k
        int res = (findTheWinner(n - 1, k) + k) % n;
        //返回结果如果为0,但是由于下标是从1开始,因此下标为0的情况说明是最后一个保留了下来
        return res == 0 ? n : res;
    }
}
