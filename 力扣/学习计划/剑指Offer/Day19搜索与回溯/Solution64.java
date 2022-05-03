package 力扣.学习计划.剑指Offer.Day19搜索与回溯;

public class Solution64 {
    /**
     * 这里不使用条件判断的话,,可以使用 &&
     * a && function()
     * 当a为真的时候才执行function
     * 也就是if的原理
     */
    public int sumNums(int n) {
        int sum = n;
        boolean flag = (n > 0) && ((sum += sumNums(n - 1)) > 0);
        return sum;
    }
}
