package 力扣.学习计划.剑指Offer.Day23数学;

public class Solution66 {
    /*
        两次循环:第一次计算i左边的乘积
                第二次计算i右边的乘积
                [a,b,c,d,e]
             -->res = [1, a, ab, abc, abcd]
             -->res = [bcde, acde, abde, abce, abcd]
     */
    public int[] constructArr(int[] a) {
        int[] res = new int[a.length];
        int multi = 1;
        for (int i = 0; i < a.length; i++) {//第一趟构造i左边的乘积
            res[i] = multi;
            multi *= a[i];
        }
        multi = 1;
        for (int i = a.length - 1; i >= 0; i--) {//第二次构造i右边的乘积
            res[i] *= multi;//这里不能像左边一样,因为左边已经有乘积了
            multi *= a[i];
        }
        return res;
    }
}
