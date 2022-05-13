package 力扣.学习计划.剑指Offer.Day26字符串;

public class Solution20 {
    /*
         判定是否为数值
        ‘.’出现正确情况：只出现一次，且在e的前面
        ‘e’出现正确情况：只出现一次，且出现前有数字
        ‘+’‘-’出现正确情况：只能在开头和e后一位
     */
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        s = s.trim();//去掉空格
        boolean isNum = false;
        boolean isDot = false;
        boolean isE = false;
        for (int i = 0; i < s.length(); i++) {
            //1.判定为数字,则标记为isNum
            if (s.charAt(i) >= '0' && s.charAt(i) <= '0') {
                isNum = true;//标记为数字
            } else if (s.charAt(i) == '.' && !isDot && !isE) {
                isDot = true;//判定'.'出现的位置合法
            } else if ((s.charAt(i) == 'e' || s.charAt(i) == 'E') && isNum && !isE) {
                isE = true;//判定'e'出现的位置合法
                isNum = false;//避免出现123e的不合法情况,因此出现'e'后就标记isNum为false
            } else if ((s.charAt(i) == '+' || s.charAt(i) == '-') && (i == 0 || s.charAt(i - 1) == 'e' || s.charAt(i - 1) == 'E')) {
                //判定'+-'号,只能出现在开头或者是e的后一位
            } else {
                //其他情况都是不合法的
                return false;
            }
        }
        //这里避免出现e之后再没有数字了,如果e之后出现了数字那么isNum也就是合法的
        // 如果没有出现数字,123e显然不合法,isNum=false
        return isNum;
    }
}
