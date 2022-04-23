package 力扣.学习计划.力扣杯.秋2019.Day5;

import java.text.DecimalFormat;
import java.util.PriorityQueue;

public class LCP1058 {
    public String minimizeError(String[] prices, int target) {
        int min = 0, max = 0;
        double[] nums = new double[prices.length];
        //将字符串转化为double
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Double.parseDouble(prices[i]);
        }
        //转化的误差最小化,,需要使用优先队列解决
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (double d : nums) {
            min += Math.floor(d);
            max += Math.ceil(d);
            priorityQueue.offer(1000 - (int) (d * 1000) % 1000);//这里是取出小数点后3位,,往上取整的差值
        }
        if (max < target || min > target) return "-1";

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i < target - min) {//弥补多往下取整的次数,所以弹出元素为向上取整的res
                res += priorityQueue.poll();
            } else {//往下取整的小数
                res += 1000 - priorityQueue.poll();
            }
        }
        //数字的格式
        DecimalFormat df = new DecimalFormat("0.000");
        return df.format(res * .001);
    }
}
