package 力扣.学习计划.算法.Day20其他;

import java.util.HashSet;
import java.util.Set;

public class Solution202 {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            //保存n的值,如果重复那么就返回false
            if (!set.add(n)) {
                return false;
            }
            set.add(n);
            int t = 0;
            while (n != 0) {
                t += Math.pow((n % 10), 2);
                n /= 10;
            }
            n = t;
        }
        return true;
    }
}
