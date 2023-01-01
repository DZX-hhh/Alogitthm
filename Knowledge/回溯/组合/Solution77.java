package LeetCode.知识点.回溯.组合;

import java.util.LinkedList;
import java.util.List;

public class Solution77 {
    LinkedList<Integer> onPath = new LinkedList<>();
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        dfs(n, k, 1);
        return res;
    }

    private void dfs(int n, int k, int start) {
        if (onPath.size() == k) {
            res.add(new LinkedList<>(onPath));
            return;
        }
        /*
            这里i>(n-(k-onPath.size())+1)之后的都满足不了  `个数为k个`
         */
        for (int i = start; i <= (n - (k - onPath.size()) + 1); i++) {
            //1.选择
            onPath.add(i);
            //2.继续dfs
            dfs(n, k, i + 1);
            //3.撤销
            onPath.removeLast();
        }
    }
}
