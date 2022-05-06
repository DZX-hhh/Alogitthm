package 力扣.学习计划.剑指Offer.Day22位运算;

import java.util.HashMap;
import java.util.Map;

public class Solution56_1 {
    /*
        哈希表
     */
    public int[] singleNumbers(int[] nums) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int index = 0;
        for (int num : nums) {
            if (map.get(num) == 1) res[index++] = num;
        }
        return res;
    }

    /*
        位运算
           a^b^b^c^c^....^z
           =a^z
       由于题目中存在两个只出现一次的a,z
       那么a和z必然是不同的-->a,z必然至少存在一个二进制位不同-->a(m)^z(m)=1-->找到这个不同的位m-->找到m后分组将a&m和z&m
       也就是说:
       找到这个这个a,z不同的二进制位m,并将整个数组分为两个子数组
                                  每个子数组都各自分配一个出现一次的数字
     */
    public int[] singleNumbers2(int[] nums) {
        int m = 1;//寻找a^z的第一个不同二进制位,左移
        int x = 0, y = 0, t = 0;
        //1.得到a^z
        for (int num : nums) {
            t ^= num;
        }
        //2.开始找不同位m
        while ((t & m) == 0) {
            m <<= 1;//m初始化为1,不断左移
        }
        //3.开始根据m分组,num&m-->第m位是否相同分组
        for (int num : nums) {
            if ((m & num) != 0) {
                x ^= num;
            } else {
                y ^= num;
            }
        }
        return new int[]{x, y};
    }
}
