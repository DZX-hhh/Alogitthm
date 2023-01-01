package LeetCode.知识点.回溯.组合;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution40 {
    LinkedList<Integer> onPath = new LinkedList<>();
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, target, 0, 0);
        return res;
    }

    private void dfs(int[] candidates, int target, int sum, int start) {
        if (sum == target) {
            res.add(new LinkedList<>(onPath));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if ((i > start && candidates[i] == candidates[i - 1])) {//剪枝,也就是i++
                continue;
            }
            if (sum <= target) {
                //三部曲
                onPath.add(candidates[i]);
                dfs(candidates, target, sum + candidates[i], i + 1);
                onPath.removeLast();
            } else {
                break;
            }
        }
    }
}