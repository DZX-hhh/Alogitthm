package LeetCode.学习计划.剑指Offer.Day22位运算;

import java.util.HashMap;

public class Solution56_2 {
    /*
        哈希表
     */
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int times = map.get(num) != null ? map.get(num) : 0;
            map.put(num, times + 1);
        }
        // 难点是HashMap中通过value获取key

        //方法一： 用keySet，for遍历
        for (int key : map.keySet()) {
            if (map.get(key) == 1) {
                return key;
            }
        }
        return nums[0];
    }

    /*
        遍历统计各个二进制位次数
        取余m(m为其他重复的次数)
        然后res从0(左移,或上(第31-i位取余m) )
     */
    public int singleNumber2(int[] nums) {
        int[] count = new int[32];//这里为32位二进制各个位的个数
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 32; j++) {
                count[j] += nums[i] & 1;//将nums[i]的最后一位1取出来,放到计数数组
                nums[i] >>>= 1;//无符号右移,这里取出32位来
            }
        }
        //这里将统计的二进制计数
        int res = 0, m = 3;
        for (int i = 0; i < 32; i++) {
            res = res << 1;//左移一位
            res |= count[31 - i] % m;//将各个二进制%m后恢复到数字res中
        }
        return res;
    }
}
