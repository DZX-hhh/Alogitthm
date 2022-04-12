package Leetcode.Study.田忌赛马;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    int[] advantageCount(int[] nums1, int[] nums2) {
        /*
         * 对nums2降序排列
         */
        PriorityQueue<int[]> maxNums2 = new PriorityQueue<int[]>(
                /*
                 * 自定义比较器写法
                 */
                (int[] Arr1, int[] Arr2) -> {
                    return Arr2[1] - Arr1[1];//降序:后者减去前者
                }
        );
        for (int i = 0; i < nums2.length; i++) {
            maxNums2.offer(new int[]{i, nums2[i]});//将nums2[i]以及其对应索引按照降序存进队列
        }
        //对nums1升序排列
        Arrays.sort(nums1);
        //left是最小的元素,right的最大的元素
        int left = 0, right = nums1.length;
        //ready是准备迎战的马
        int[] ready = new int[nums2.length];
        /*
         *当所有的马都参加完比赛
         */
        while (!maxNums2.isEmpty()) {
            int[] maxnums2 = maxNums2.poll();//弹出优先队列队头元素
            if (nums1[right] > maxnums2[1]) {//如果nums1最大的值(最快的马)比的赢,就冲
                ready[maxnums2[0]] = nums1[right];//记录能冲的最快的马出战的顺序
                right--;
            } else {//如果nums1最快的马比不赢,那就摆烂,以小博大
                ready[maxnums2[0]] = nums1[left];//记录nums1最小的值,开摆
                left++;
            }
        }
        return ready;
    }
}
