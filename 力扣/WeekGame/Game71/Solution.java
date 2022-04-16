package 力扣.WeekGame.Game71;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

public class Solution {
    public int minimumSum(int num) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < 4; i++) {
            queue.offer(String.valueOf(num).charAt(i) - '0');
        }
        int num1 = queue.poll();
        int num2 = queue.poll();
        int num3 = queue.poll();
        int num4 = queue.poll();
        return num1 * 10 + num2 + num3 * 10 + num4;
    }

    public int[] pivotArray(int[] nums, int pivot) {
        Deque<Integer> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();
        Deque<Integer> stack3 = new ArrayDeque<>();
        for (int i : nums) {
            if (i < pivot) {
                stack1.add(i);
            } else if (i > pivot) {
                stack2.add(i);
            } else {
                stack3.add(i);
            }
        }
        int i = 0;
        while (!stack1.isEmpty()) nums[i++] = stack1.poll();
        while (!stack3.isEmpty()) nums[i++] = stack3.poll();
        while (!stack2.isEmpty()) nums[i++] = stack2.poll();
        return nums;
    }


    public int minCostSetTime(int startAt, int moveCost, int pushCost, int targetSeconds) {
        int min1 = targetSeconds / 60;
        int second1 = targetSeconds % 60;
        int min2 = min1 - 1;
        int second2 = second1 + 60;
        return Math.min(cost(startAt, moveCost, pushCost, min1, second1),
                cost(startAt, moveCost, pushCost, min2, second2));
    }

    public int cost(int startAt, int moveCost, int pushCost, int min, int second) {
        int res = 0;
        //处理min-1,second+60出现的异常情况
        if (min > 99 || second > 99 || min < 0) return Integer.MAX_VALUE;
        int[] time = new int[4];
        time[0] = min / 10;
        time[1] = min % 10;
        time[2] = second / 10;
        time[3] = second % 10;
        int index = 0;
        //排除前置"0"
        while (time[index] == 0) index++;
        int now = startAt;
        while (index < 4) {
            if (now == time[index]) res += pushCost;
            else {
                res += (moveCost + pushCost);
                now = time[index];
            }
            index++;
        }
        return res;
    }
}
