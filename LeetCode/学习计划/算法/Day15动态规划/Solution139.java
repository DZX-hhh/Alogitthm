package LeetCode.学习计划.算法.Day15动态规划;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution139 {
    /*
        类似于分割回文串:枚举分割子串,判断是否回文
        这里是枚举分割子串,判断是否都在字典里面找得到
        由于存在很多数据重复计算,这里每分割一次就记录结果,以便再次利用
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);//将列表元素加入集合
        return dfs(s, set, 0);
    }

    /*
        枚举分割子串,,分割后是否都能在set找到
     */
    private boolean dfs(String s, Set<String> set, int startIndex) {
        if (startIndex >= s.length()) {
            return true;
        }
        for (int i = startIndex; i < s.length(); i++) {
            String subStr = s.substring(startIndex, i + 1);
            if (set.contains(subStr) && dfs(s, set, i + 1)) {
                return true;
            }
        }
        return false;
    }

    /*
        上面的改进版,增加了int[]memory记录startIndex是否符合要求,备忘录
     */
    public boolean wordBreak2(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);//将列表元素加入集合
        int[] memory = new int[s.length()];
        Arrays.fill(memory, -1); // -1 表示初始化状态
        return dfs2(s, set, 0, memory);
    }

    /*
        枚举分割子串,,分割后是否都能在set找到
     */
    private boolean dfs2(String s, Set<String> set, int startIndex, int[] memory) {
        if (startIndex >= s.length()) {
            return true;
        }
        if (memory[startIndex] != -1) {
            return memory[startIndex] == 1;
        }
        for (int i = startIndex; i < s.length(); i++) {
            String subStr = s.substring(startIndex, i + 1);
            if (set.contains(subStr) && dfs2(s, set, i + 1, memory)) {
                memory[startIndex] = 1;// 记录以startIndex开始的子串是不可以被拆分的
                return true;
            }
        }
        memory[startIndex] = 0;// 记录以startIndex开始的子串是可以被拆分的
        return false;
    }


    /**
     * @param s        字符串-->背包
     * @param wordDict 单词-->物品
     * @return "01背包问题"
     * 又因为可以多次出现一个单词,因此又是完全背包
     * > 如果求组合数,外层for物品,内层for背包
     * > 如果求排列数,外层for背包,内层for物品
     * dp[i]含义:字符串(背包)长度为i,可以拆分为一个或多个出现在字典中的单词(物品)
     * 递推方程:如果dp[j]=true,并且[j,i]出现在字典中(j<i),dp[i]=true
     */
    public boolean wordBreak3(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;//这里是为了后面铺垫使用,实际没有意义
        /*
            本题最终要求的是是否都出现过，所以对出现单词集合里的元素是组合还是排列，并不在意！
         */
        for (int i = 1; i <= s.length(); i++) {//遍历背包
            for (int j = 0; j < i; j++) {//遍历物品
                String subStr = s.substring(j, i + 1);//截取字符串
                if (dp[j] && wordDict.contains(subStr)) {
                    dp[j] = true;
                }
            }
        }
        return dp[s.length()];
    }
}
