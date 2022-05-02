package 力扣.知识点.回溯.组合;

import java.util.LinkedList;
import java.util.List;

public class Solution39 {
    LinkedList<Integer> onPath = new LinkedList<>();
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates, target, 0, 0);
        return res;
    }

    private void dfs(int[] candidates, int target, int sum, int start) {
        if (sum == target) {
            res.add(new LinkedList<>(onPath));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (sum > target) {//剪枝,,也就是由这里i+1
                continue;
            }
            //1.选择
            onPath.add(candidates[i]);
            //2.递归,,这里candidates[i]依然可以选择若干次
            dfs(candidates, target, sum + candidates[i], i);
            //3.撤销
            onPath.removeLast();
        }
    }
}
