package 力扣.学习计划.算法.Day15动态规划;

import java.util.LinkedList;
import java.util.List;

public class Solution131 {
    /*
        这里分两步:1.组合分割问题
                 2.验证是否为回文串
     */
    LinkedList<String> onPath = new LinkedList<>();//记录切割后的回文串
    List<List<String>> res = new LinkedList<>();

    public List<List<String>> partition(String s) {
        dfs(s, 0);
        return res;
    }

    /**
     * @param s          字符串
     * @param startIndex 分割的起始位置
     */
    private void dfs(String s, int startIndex) {
        if (startIndex >= s.length()) {
            res.add(new LinkedList<>(onPath));
            return;
        }
        //开始遍历截取字符串
        for (int i = startIndex; i < s.length(); i++) {
            //这里分为两部分,[startIndex,i] 和 [i+1,s.length]
            if (isPrime(s, startIndex, i)) { //双指针判断是否为回文串
                //三部曲
                onPath.add(s.substring(startIndex, i + 1));
                dfs(s, i + 1);
                onPath.removeLast();
            }
        }
    }

    /**
     * @param s
     * @param startIndex
     * @param i
     * @return s的[startIndex, i]部分是否为回文串
     */
    private boolean isPrime(String s, int startIndex, int i) {
        for (int left = startIndex, right = i; left < right; left++, right--) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
        }
        return true;
    }
}
