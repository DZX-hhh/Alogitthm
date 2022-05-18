package LeetCode.学习计划.剑指Offer.Day24数学;

import java.util.LinkedList;
import java.util.List;

public class Solution57 {
    public int[][] findContinuousSequence(int target) {
        int left = 1;//左边界
        double right = 2.0;//右边界
        List<int[]> res = new LinkedList<>();
        while (left < right) {//因为这里求和至少要求两个数,因此不能相等
            right = (-1 + Math.sqrt(1 + 4 * (2 * target + ((long) left * left) - left))) / 2;
            //这里根据求和公式,知道左边界left和和target-->right
            if (left < right && right == (int) right) {
                int[] arr = new int[(int) right - left + 1];
                for (int i = left; i <= (int) right; i++) {
                    arr[i - left] = i;
                }
                res.add(arr);
            }
            left++;
        }
        return res.toArray(new int[0][]);//这里把res<int[]>当作数组[0][里面还是数组]
    }

    /*
        滑动窗口
        当sum<target:  right++
          sum==target  right++,并且记录此时序列
          sum>target   left++
     */
    public int[][] findContinuousSequence2(int target) {
        List<int[]> res = new LinkedList<>();
        int left = 1, right = 2, sum = 3;
        while (left < right) {
            if (sum == target) {//记录答案
                int[] arr = new int[right - left + 1];
                for (int i = left; i <= right; i++) {
                    arr[i - left] = i;
                }
                res.add(arr);
            }
            if (sum < target) {//向右移动右边界
                right++;
                sum += right;
            } else if (sum >= target) {//向左移动左边界
                sum -= left;
                left++;
            }
        }
        return res.toArray(new int[0][]);
    }
}
