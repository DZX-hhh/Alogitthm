package 力扣.学习计划.力扣杯.秋2019.Day7;

import java.util.Deque;
import java.util.LinkedList;

public class LCP1063 {

    public int validSubarray2(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[j] >= nums[i]) res++;
                else break;
            }
        }
        return res;
    }

    public int validSubarrays(int[] nums) {
        if (nums.length <= 1) return nums.length;
        Deque<Integer> stack = new LinkedList<>();
        int res = 0;
        for (int num : nums) {
            while (!stack.isEmpty() && stack.peek() > num) {
                stack.pop();
            }
            stack.push(num);
            res += stack.size();//这里加size可以理解为当这个数之前的这些数字作为第一个的时候,,是可以的
        }
        return res;
    }
}

