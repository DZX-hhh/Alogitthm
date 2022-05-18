package LeetCode.学习计划.算法.Day11递归回溯;

import java.util.LinkedList;
import java.util.List;

public class Solution17 {
    /*
        不同结合之间的排列组合问题
        start意义不一样,这里start代表的是遍历到哪个组合了,然后组合内遍历
     */

    //解决数字对字符的映射

    List<String> res = new LinkedList<>();
    String[] numToString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    // 0   1     2      3      4      5      6      7       8     9

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return res;
        }
        dfs(digits, 0);
        return res;
    }

    StringBuilder sb = new StringBuilder();

    /**
     * @param digits 数字字符串
     * @param index  当前在遍历的第index个数字
     */
    public void dfs(String digits, int index) {
        if (index == digits.length()) {
            res.add(sb.toString());
            return;
        }
        //当前数字
        int digit = digits.charAt(index) - '0';
        //当前数字对应的字母串
        String s = numToString[digit];
        //遍历当前字母串的每个字母
        for (int i = 0; i < s.length(); i++) {
            //三部曲
            sb.append(s.charAt(i));
            dfs(digits, index + 1);//开始选择下一个数字对应的字符串
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
