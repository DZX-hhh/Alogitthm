package 力扣.学习计划.力扣杯.秋2019.Day6;

public class LCP1062 {
    /*滑动窗口解决字串问题*/
    public int longestRepeatingSubstring(String s) {
        int res = 0, left = 0, right = 0;
        while (right < s.length()) {
            if (left == right) {
                right++;
                continue;
            }
            //字符串截取,如过从`left+1`的位置开始查找窗口内的字符
            int index = s.indexOf(s.substring(left, right + 1), left + 1);
            if (index >= 0) {//如果查到了重复内容,比较更长的长度
                res = Math.max(res, right - left + 1);
                right++;//窗口继续滑动
            } else {
                left++;
            }
        }
        return res;
    }
}
