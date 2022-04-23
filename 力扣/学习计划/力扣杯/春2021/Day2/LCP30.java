package 力扣.学习计划.力扣杯.春2021.Day2;

import java.util.PriorityQueue;

public class LCP30 {
    //讲究续航
    public int magicTower(int[] nums) {
        int sum = 1;
        for (int num : nums) {
            sum += num;
        }
        if (sum <= 0) return -1; //总的所有回合的血量不够通关

        int res = 0;
        //开始模拟
        long blood = 1;
        //优先队列,,由于存储的都是负数,那么最小的就是扣血最多的小怪,,在临死前,复活选择恢复扣血最多的小怪
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                priorityQueue.offer(nums[i]);
            }
            blood += nums[i];
            if (blood <= 0) {//即将死亡
                blood -= priorityQueue.poll();//恢复:选择扣血最多的小怪
                res++;
            }
        }
        return res;
    }
}
