package 力扣.学习计划.剑指Offer.Day21位运算;

public class Solution15 {
    /*
        库函数
     */
    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }

    /*
        二进制右移动,log(n)
     */
    public int hammingWeight2(int n) {
        int res = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                res++;
            }
            n = n >>> 1;//>>代表有符号右移,,>>>代表无符号右移
        }
        return res;
    }

    /*
        巧用n&(n-1)
        n-1这里的意思是:将n二进制  最右边的1变为0    并让1右边的0全部变为1
        n&(n-1)这里的意思是:恰好将将刚才最右边的1抹掉
     */
    public int hammingWeight3(int n) {
        int res = 0;
        while (n != 0) {
            res++;
            n = n & (n - 1);
        }
        return res;
    }
}



