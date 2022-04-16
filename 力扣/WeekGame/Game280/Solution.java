package 力扣.WeekGame.Game280;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public int countOperations(int num1, int num2) {
        if (num1 == 0 || num2 == 0) {
            return 0;
        }
        int res = 0;
        while (num1 != 0 && num2 != 0) {
            if (num1 >= num2) {
                num1 = num1 - num2;
            } else {
                num2 = num2 - num1;
            }
            res++;
        }
        return res;
    }


    public int minimumOperations(int[] nums) {
        int count = 0;
        int n = nums.length;
        if (nums.length < 2) {
            return count;
        }

        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                map1.put(nums[i], map1.getOrDefault(nums[i], 0) + 1);
            } else {
                map2.put(nums[i], map2.getOrDefault(nums[i], 0) + 1);
            }
        }
        //找到两个出现次数最多和次多的key和value
        int[][] maxAndSecond_1 = maxAndSecond(map1);
        int[][] maxAndSecond_2 = maxAndSecond(map2);

        //如果map1和map2出现次数最多的数key不相等,那么只需要nums.length-value1-value2
        if (maxAndSecond_1[0][0] != maxAndSecond_2[0][0]) {
            n -= maxAndSecond_1[0][1];
            n -= maxAndSecond_2[0][1];
        } else {//反之如果出现两个出现次数最多的key相等
            // 就要比较两个map里面最大次数以及第二多次数的次数之和相比较,取出频率较大的和
            n -= Math.max(maxAndSecond_1[0][1] + maxAndSecond_2[1][1], maxAndSecond_2[0][1] + maxAndSecond_1[1][1]);
        }
        return n;
    }

    /**
     * @param map
     * @return int[][] arr,
     * arr[0]代表出现次数第一多的kay和value,
     * arr[1]代表第二多的key和value
     */
    public int[][] maxAndSecond(HashMap<Integer, Integer> map) {
        int[][] res = new int[2][2];
        for (int key : map.keySet()) {
            int value = map.get(key);
            //如果值大于次数第一多的,那么就更新答案
            if (value > res[0][1]) {
                //更新第二多的key以及value
                res[1][0] = res[0][0];
                res[1][1] = res[0][1];
                res[0][0] = key;
                res[0][1] = value;
            } else if (value > res[1][1]) {//次数第二多的value
                res[1][0] = key;
                res[1][1] = value;
            }
        }
        return res;
    }


    public long minimumRemoval(int[] beans) {
        Arrays.sort(beans);
        //最多剩余的豆子数量
        long max = 0;
        long sum = 0;
        for (int i = 0; i < beans.length; i++) {
            //排序之后,i前面的豆子都删除,后面的数字都保留成bean[i]
            max = Math.max((long) beans[i] * (beans.length - i), max);
            sum += (long) beans[i];
        }
        return sum -= max;
    }
}
