package 力扣.学习计划.剑指Offer.Day26字符串;

public class Solution8 {
    public int myAtoi(String s) {
        int res = 0, flag = 1;//默认为正向
        char[] chars = s.toCharArray();
        int start = 0;
        //处理空格的情况
        for (int i = 0; i < s.length(); i++) {
            if (chars[i] != ' ') {
                start = i;
                break;
            }
        }
        //超出边界
        if (start >= s.length()) {
            return 0;
        }
        //判断非空格首字母是否为`-`
        if (chars[start] == '-') {
            flag = -1;//记录为负数
            start++;
        } else if (chars[start] == '+') {
            start++;
        } else if (!Character.isDigit(chars[start])) {//遇见其他符号
            return 0;
        }
        //迭代乘法
        for (int end = start; end < s.length() && Character.isDigit(chars[end]); end++) {
            int digit = chars[end] - '0';
            //这里需要判断是否溢出res*10+digit>max
            //res*10和+digit都有可能溢出,因此全移到右边
            if (res > (Integer.MAX_VALUE - digit) / 10) {
                return flag > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + digit;
        }
        return res * flag;
    }
}
