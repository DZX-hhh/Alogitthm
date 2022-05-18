package LeetCode.学习计划.编程能力.Day3;

public class Solution66 {
    public int[] plusOne(int[] digits) {
        //两种情况
        // 1.正常情况,遇见不是9的
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            }
            //2.如果是9,那么就需要进位,让当前元素为0,转到下一位+1
            digits[i] = 0;
        }
        //3.如果全是9,则直接增加长度,让第一个为1即可
        int[] plusone = new int[digits.length + 1];
        plusone[0] = 1;
        return plusone;
    }
}
