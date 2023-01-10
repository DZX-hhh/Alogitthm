package LeetCode.学习计划.算法.Day11递归回溯;

import java.util.LinkedList;
import java.util.List;

public class Solution22 {

    List<String> res = new LinkedList<>();

    public List<String> generateParenthesis(int n) {
        dfs(n, "", 0, 0);
        return res;
    }

    /*
        这里n对-->n个'(' 和 n个')'
        dfs+剪枝
        当'(' 数目< ')'的时候不再考虑
     */
    private void dfs(int n, String s, int leftCount, int rightCount) {
        //剪枝
        if (leftCount > n || rightCount > n || rightCount > leftCount) {
            return;
        }
        if (leftCount == n && rightCount == n) {
            res.add(s);
            return;
        }
        dfs(n, s + '(', leftCount + 1, rightCount);
        dfs(n, s + ')', leftCount, rightCount + 1);
    }

    public List<String> generateParenthesis2(int n) {
        dfs2("", n, n);
        return res;
    }

    private void dfs2(String s, int leftCount, int rightCount) {
        if (leftCount < 0 || rightCount < 0 || rightCount < leftCount) {
            return;
        }
        if (leftCount == 0 && rightCount == 0) {
            res.add(s);
            return;
        }
        dfs2(s + '(', leftCount - 1, rightCount);
        dfs2(s + ')', leftCount, rightCount - 1);
    }
}
