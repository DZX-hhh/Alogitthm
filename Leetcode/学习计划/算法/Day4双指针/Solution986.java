package LeetCode.学习计划.算法.Day4双指针;

import java.util.LinkedList;
import java.util.List;

public class Solution986 {
    /**
     * 1.是否有交集
     * 2.记录交集
     *
     * @param firstList
     * @param secondList
     * @return
     */
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> res = new LinkedList<>();
        int first = 0, second = 0;
        while (first < firstList.length && second < secondList.length) {
            int[] tempFirst = firstList[first];
            int[] tempSecond = secondList[second];
            //如果无交集
            if (tempFirst[0] > tempSecond[tempSecond.length - 1]) {
                second++;
            } else if (tempSecond[0] > tempFirst[tempFirst.length - 1]) {
                first++;
            } else {
                int biggerBegin = Math.max(tempFirst[0], tempSecond[0]);//更大的起始值
                int smallerEnd = Math.min(tempFirst[tempFirst.length - 1], tempSecond[tempSecond.length - 1]);//更小的结束值
                res.add(new int[]{biggerBegin, smallerEnd});
                if (smallerEnd == tempFirst[tempFirst.length - 1]) {
                    first++;
                } else {
                    second++;
                }
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
