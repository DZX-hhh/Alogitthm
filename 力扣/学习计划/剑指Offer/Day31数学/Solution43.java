package 力扣.学习计划.剑指Offer.Day31数学;

public class Solution43 {
    public int countDigitOne(int n) {
        return f(n);
    }

    /**
     * @return 1到n中的数字中含有1的个数
     * <p>
     * 用 1234 和 2345 来举例
     */
    private int f(int n) {
        //不存在"1"
        if (n == 0) {
            return 0;
        }
        //1..9只有1出现"1"
        if (n < 10) {
            return 1;
        }
        String s = String.valueOf(n);
        //长度：按例子来说是4位
        int length = s.length();
        //这个base是解题速度100%的关键，本例中的是999中1的个数：300
        // 9的话就是1 ; 99的话就是20 ; 9999就是4000
        int base = (int) ((length - 1) * Math.pow(10, length - 2));//这里是(4-1)*(10^2)=300,求出当前数量级前面的base数

        //high就是最高位的数字
        int high = s.charAt(0) - '0';
        //curr就是当前所在数量级,即1000
        int curr = (int) Math.pow(10, length - 1);
        if (high == 1) {
            //最高位为1,,1  +  (n-curr)就是1000~1234中又千位数(1000)提供的1的个数
            //剩下的由234提供1的个数
            return base + 1 + (n - curr) + f(n - high * curr);//f(1234-1*1000)
        } else {
            //如果当前最高位>1,那么说明有超过1个的千位数(1000..2000..)提供(999的base数目的倍数)
            //base*high+curr的含义就是提供"999"出现次数的倍数+ "1###"的次数
            return base * high + curr + f(n - high * curr);
        }
    }
}
