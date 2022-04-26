package 力扣.学习计划.算法.Day4双指针;

public class Solution844 {
    public boolean backspaceCompare(String s, String t) {
        int indexS = s.length() - 1, indexT = t.length() - 1;
        int countS = 0, countT = 0;//s和t中含有'#'的数量
        while (indexS >= 0 || indexT >= 0) {
            //1.当s出现'#'的时候,计数'#'的个数
            while (indexS >= 0) {
                if (s.charAt(indexS) == '#') {//2.计数
                    countS++;
                    indexS--;
                } else if (countS > 0) {//3.开始删除元素,indexS--
                    indexS--;
                    countS--;
                } else {
                    break;
                }
            }
            //同上
            while (indexT >= 0) {
                if (t.charAt(indexT) == '#') {
                    countT++;
                    indexT--;
                } else if (countT > 0) {
                    countT--;
                    indexT--;
                } else {
                    break;
                }
            }
            if (indexS >= 0 && indexT >= 0) {
                if (s.charAt(indexS) != t.charAt(indexT)) {//当出现不匹配的
                    return false;
                }
            } else {
                if (indexS >= 0 || indexT >= 0) {//当至少有一个没匹配完
                    return false;
                }
            }

            //当前匹配结束,继续遍历
            indexS--;
            indexT--;
        }
        return true;
    }
}
