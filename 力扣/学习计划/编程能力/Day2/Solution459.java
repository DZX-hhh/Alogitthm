package 力扣.学习计划.编程能力.Day2;

public class Solution459 {
    /**
     * 假设`S`不存在重复的子字串,那么就把`S`作为重复的子字符串相加成为`S+S`
     * `S+S`只有唯一的重复子字符串-->`S`
     * 因此如果去掉首尾两个字符,,`S+S`就不再含有重复子字符串`S`了
     */
    public boolean repeatedSubstringPattern(String s) {
        String ss = s + s;
        return ss.substring(1, ss.length() - 1).contains(s);
    }
}
