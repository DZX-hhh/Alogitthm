package 力扣.每日一题.Four.Four24;

public class Solution {
    /*位运算
         ` n & 1 `可以得出二进制最低位
         ` n=n>>1` 右移
     */
    public int binaryGap(int n) {
        int last = -1, res = 0;
        for (int i = 0; n != 0; i++) {//条件为n不为0
            if ((n & 1) == 1) {//如果发现最后一位是1
                if (last != -1) {//如果不是第一个`1`,那么直接比较更大值
                    res = Math.max(res, i - last);
                    last = i;
                } else {//更新上一个出现的`1`
                    last = i;
                }
            }
            //将n右移动一位
            n = n >> 1;
        }
        return res;
    }


    //将n转化为二进制的字符串,再遍历
    public int binaryGap2(int n) {
        int last = -1, res = 0;
        String tobinaryString = Integer.toBinaryString(n);
        System.out.println(tobinaryString);
        for (int i = 0; i < tobinaryString.length(); i++) {
            if (tobinaryString.charAt(i) - '0' == 1) {
                if (last != -1) {
                    res = Math.max(res, i - last);
                    last = i;
                } else {
                    last = i;
                }
            }
        }
        return res;
    }
}
