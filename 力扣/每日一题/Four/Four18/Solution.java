package 力扣.每日一题.Four.Four18;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    List<Integer> res = new LinkedList<>();

    public List<Integer> lexicalOrder(int n) {

        //字典树的深度优先访问
        for (int i = 1; i <= 9; i++) {
            dfs(i, n);
        }
        return res;
    }

    //深度优先搜索,,递归版
    private void dfs(int cur, int limit) {
        if (cur > limit) return;//如果超出范围,那么就返回
        res.add(cur);
        for (int son = 0; son <= 9; son++) {//依次访问字典树的10个子节点
            dfs(cur * 10 + son, limit);
        }
    }

    //迭代版
    public List<Integer> lexicalOrder2(int n) {
        List<Integer> ans = new LinkedList<>();
        for (int i = 0, cur = 1; i < n; i++) {
            ans.add(cur);
            if (cur * 10 <= n) {
                cur *= 10;//这里跳到下一层,直到最后一层,深度优先
            } else {
                while (cur % 10 == 9 || cur + 1 > n) {//最后一层的9
                    cur /= 10;//跳到上一层
                }
                cur++;//10个子节点,由左到右加到最后一个(0到9)
            }
        }
        return ans;
    }
}
