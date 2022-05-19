package LeetCode.每日一题.Five.Day20;

import java.util.Arrays;

public class Solution436 {
    /**
     * 二分查找
     * 右区间第一个大于endI的startJ的下标
     */
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[] res = new int[n];
        //每个位置的记录
        int[][] startIntervals = new int[n][2];
        for (int i = 0; i < n; i++) {
            startIntervals[i][0] = intervals[i][0];//每个起始位置StartJ的值,排序后二分比较[i][1]
            startIntervals[i][1] = i;//下标右端点endI的下标,默认为自己
        }
        //这里让起始值升序,,寻找 `大于` `当前右端点` 的 `最小起始值`的 `下标`
        Arrays.sort(startIntervals, (arr1, arr2) -> {
            return arr1[0] - arr2[0];
        });
        for (int i = 0; i < n; i++) {
            //二分模板,求左边界
            int left = 0, right = n - 1;
            int target = -1;//要找到大于右端点的最小值下标
            while (left <= right) {
                int mid = (left + right) >> 1;
                if (intervals[i][1] > startIntervals[mid][0]) {
                    left = mid + 1;
                } else {
                    //找到比右端点大的点,更新target为下标
                    target = startIntervals[mid][1];
                    right = mid - 1;
                }
            }
            res[i] = target;
        }
        return res;
    }
}
