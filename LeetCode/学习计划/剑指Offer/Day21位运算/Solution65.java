package LeetCode.学习计划.剑指Offer.Day21位运算;

public class Solution65 {
    public int add(int a, int b) {
        while (b != 0) {//当b为0,,说明进位为0,加法结束
            int c = (a & b) << 1;//& 进位:向左移一位
            a ^= b;//^ 无进位加法
            b = c;//更新b为进位
        }
        return a;
    }
}
