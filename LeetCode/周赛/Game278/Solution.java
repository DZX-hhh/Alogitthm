package LeetCode.周赛.Game278;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public int findFinalValue(int[] nums, int original) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], nums[i]);
        }
        while (map.containsKey(original)) {
            original *= 2;
        }
        return original;
    }

    public List<Integer> maxScoreIndices(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int max = -1;
        int[] pre0 = new int[nums.length + 1];
        int[] pre1 = new int[nums.length + 1];
        for (int i = 1; i < pre0.length; i++) {
            pre0[i] = nums[i - 1] == 0 ? pre0[i - 1] + 1 : pre0[i - 1];
            pre1[i] = nums[i - 1] == 1 ? pre1[i - 1] + 1 : pre1[i - 1];
        }
        for (int i = 0; i < pre0.length; i++) {
            if (pre0[i] + pre1[pre1.length - 1] - pre1[i] > max) {
                max = pre0[i] + pre1[pre1.length - 1] - pre1[i];
            }
        }
        for (int i = 0; i < pre1.length; i++) {
            if (pre0[i] + pre1[pre1.length - 1] - pre1[i] == max) {
                res.add(i);
            }
        }
        return res;
    }


    /**
     * 反向滑动窗口
     * 除法取模不可行
     * (a+b*c) % Mod=d
     * b≠(d-a)/c%mod
     *
     * @param s
     * @param power
     * @param modulo
     * @param k
     * @param hashValue
     * @return
     */
    public String subStrHash(String s, int power, int modulo, int k, int hashValue) {
        int n = s.length();
        //hashVal的索引,需要不断更新
        int index = 0;
        long hashVal = 0;
        long p = 1;//记录power的n-1次方

        //初始化窗口,从后往前,将除法取余的问题换成 乘法
        for (int i = n - 1; i > n - k + 1; i--) {
            p = p * power % modulo;
            hashVal = (hashVal * power + s.charAt(i) - 'a' + 1) % modulo;
        }
        if (hashVal == hashValue) index = n - k;
        //多一个头，少一个尾:
        for (int i = n - k - 1; i >= 0; i--) {
//            所有要做减法求模的行为要小心结果为负数，我们减法之前先加上 mod，保证结果为正。
            hashVal = ((s.charAt(i) - 'a' + 1)
                    + (hashVal - (long) (s.charAt(i + k) - 'a' + 1) * p % modulo + modulo) * power) % modulo;
            if (hashVal == hashValue) index = i;
        }
        return s.substring(index, index + k);
    }
}
