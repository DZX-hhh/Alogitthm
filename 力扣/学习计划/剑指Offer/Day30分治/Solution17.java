package 力扣.学习计划.剑指Offer.Day30分治;

import java.util.ArrayList;
import java.util.List;

public class Solution17 {
    /*
        模拟
     */
    public int[] printNumbers(int n) {
        int[] res = new int[(int) (Math.pow(10, n) - 1)];
        for (int i = 0; i < res.length; i++) {
            res[i] = i + 1;
        }
        return res;
    }

    /**
     * 考虑大数问题(溢出)
     * 使用字符串输出,从高位向低位,凭借0-9 考虑首位0的情况
     */
    List<String> res = new ArrayList<>();
    StringBuffer sb = new StringBuffer();
    char[] loop = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public List<String> printNumbers2(int n) {
        for (int i = 1; i <= n; i++) {
            dfs(0, i);//依次第0位,生成[1...n]位的数字
        }
        return res;
    }

    /**
     * @param i   当前正在固定第i位
     * @param len 生成长度为len的数字
     *            当i=0,表示在最左边第1位,不能为0
     */
    private void dfs(int i, int len) {
        if (i == len) {//当[0...n-1]全部固定好之后
            res.add(sb.toString());//加入答案
            return;
        }
        int start = i == 0 ? 1 : 0;//当i=0,表示左边第1位数字不能位0,直接从1开始
        for (int t = start; t <= 9; t++) {
            sb.append(t);//固定好当前位置
            dfs(t + 1, len);//开始确认下一位数字
            sb.deleteCharAt(t);//回溯
        }
    }
}
