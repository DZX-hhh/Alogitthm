package 力扣.学习计划.剑指Offer.Day16排序;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

public class Solution45 {
    /*
        这里前面的数字应该越小越好,尝试优先队列
        规则:"a"+"b"<"b"+"a",说明"a"要更小,应该放在前面
     */
    public String minNumber(int[] nums) {
        StringBuilder res = new StringBuilder();
        //优先队列,小根堆
        PriorityQueue<String> priorityQueue = new PriorityQueue<>(
                //比较,字典序小放在前面
                (String s1, String s2) -> {
                    return (s1 + s2).compareTo(s2 + s1);
                });
        for (int num : nums) {
            priorityQueue.offer("" + num);
        }
        while (!priorityQueue.isEmpty()) {
            res.append(priorityQueue.poll());
        }
        return res.toString();
    }

    public String minNumber2(int[] nums) {
        StringBuilder res = new StringBuilder();
        String[] numStr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numStr[i] = String.valueOf(nums[i]);
        }
        //排序:规则:"a"+"b"<"b"+"a",说明"a"要更小,应该放在前面
        Arrays.sort(numStr, (s1, s2) -> (s1 + s2).compareTo(s2 + s1));
        for (String s : numStr) {
            res.append(s);
        }
        return res.toString();
    }

    /*
        快速排序
     */
    public String minNumber3(int[] nums) {
        StringBuilder res = new StringBuilder();
        String[] numStr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numStr[i] = String.valueOf(nums[i]);
        }
        //快速排序
        quickSort(numStr, 0, nums.length - 1);
        for (int i = 0; i < nums.length; i++) {
            res.append(numStr[i]);
        }
        return res.toString();
    }

    /*
        规则:"a"+"b"<"b"+"a",说明"a"要更小,应该放在前面
        快速排序:找到一个数,让左边的都小于这个数,右边的都大于这个数
     */
    private void quickSort(String[] numStr, int low, int high) {
        if (low < high) {
            int pilot = partition(numStr, low, high);
            quickSort(numStr, low, pilot - 1);
            quickSort(numStr, pilot + 1, high);
        }
    }

    /*
        //使得pilot左边的都比它小,pilot右边的都大
     */
    private int partition(String[] numStr, int low, int high) {
        Random random = new Random();
        //生成[low,high]之内的随机数
        int r = random.nextInt(high + 1 - low) + low;
        //把这个调到最后面去
        swap(numStr, r, high);
        int i = low;
        for (int j = low; j <= high - 1; j++) {
            //默认是增加的
            //这里排序规则由小于变成-->"a"+"b"<"b"+"a",说明"a"要更小,应该放在前面
            if ((numStr[j] + numStr[high]).compareTo(numStr[high] + numStr[j]) < 0) {
                swap(numStr, i, j);
                i++;
            }
        }
        //交换此时的最后面的值和当前
        swap(numStr, i, high);

        return i;
    }

    //交换位置
    private void swap(String[] numStr, int i, int j) {
        String s = numStr[i];
        numStr[i] = numStr[j];
        numStr[j] = s;
    }
}
