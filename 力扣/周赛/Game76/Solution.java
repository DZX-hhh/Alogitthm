package 力扣.周赛.Game76;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    public int findClosestNumber(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(
                (a, b) -> {
                    return b - a;
                }
        );
        for (int num : nums) {
            if (num == 0) {
                return 0;
            } else if (num > 0) {
                pq.offer(num);
            } else {
                pq2.offer(num);
            }
        }
        if (pq.size() == 0) {
            return pq2.poll();
        } else if (pq2.size() == 0) {
            return pq.poll();
        } else {
            if (pq.peek() + pq2.peek() > 0) return pq2.poll();
            else return pq.poll();
        }
    }

    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        int num1 = total / cost1;
        long count = 0;
        for (int i = 0; i <= num1; i++) {
            count += (total - i * cost1) / cost2 + 1;
        }
        return count;
    }
}

class ATM {
    int[] money;
    long[] count;

    public ATM() {
        money = new int[]{20, 50, 100, 200, 500};
        count = new long[5];
    }

    //存钱
    public void deposit(int[] banknotesCount) {
        for (int i = 0; i < banknotesCount.length; i++) {
            count[i] += banknotesCount[i];
        }
    }

    public int[] withdraw(int amount) {
        //答案,每取完一种面值的钱,就赋值,记录取了多少
        int[] res = new int[5];

        //备份
        long[] copy = Arrays.copyOf(count, count.length);

        //开始取钱
        for (int i = 4; i >= 0 && amount > 0; i--) {
            //当前面值有钱,,并且需要取出的钱大于当前面值,那么就开始尝试取钱
            if (count[i] > 0 && amount >= money[i]) {
                //如果需要一次性取出,那么就取出
                if (amount >= money[i] * count[i]) {
                    amount -= money[i] * count[i];
                    //记录
                    res[i] = (int) count[i];
                    count[i] = 0;
                } else {
                    //当前面值总额大于需要取的钱,那就只取一部分,或者不取
                    res[i] = amount / money[i];//取走的数目
                    count[i] -= amount / money[i];//剩余的是总共的减去取走的

                    amount %= money[i];//还需要取走多少钱,这里如果要取250,有300(6张50的面额),那么恰好可以全部取完
                    //如果300是(3张100),,那么就不能正常取钱,还剩余50要取,那么就跳到50的地方取
                }
            }
        }
        //如果全取走了的话,那么就可以返回res
        if (amount == 0) return res;

        //回滚
        count = copy;
        return new int[]{-1};
    }
}
/**
 * Your ATM object will be instantiated and called as such:
 * ATM obj = new ATM();
 * obj.deposit(banknotesCount);
 * int[] param_2 = obj.withdraw(amount);
 */

