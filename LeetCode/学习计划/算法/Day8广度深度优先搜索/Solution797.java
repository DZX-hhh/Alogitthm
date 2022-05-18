package LeetCode.学习计划.算法.Day8广度深度优先搜索;

import java.util.LinkedList;
import java.util.List;

public class Solution797 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> onPath = new LinkedList<>();
        dfs(graph, res, onPath, 0);
        return res;
    }

    private void dfs(int[][] graph, LinkedList<List<Integer>> res, LinkedList<Integer> onPath, int From) {
        int n = graph.length;
        onPath.addLast(From);
        if (From == n - 1) {
            res.add(new LinkedList<>(onPath));
            onPath.removeLast();
            return;
        }
        for (int To : graph[From]) {
            dfs(graph, res, onPath, To);
        }
        onPath.removeLast();
    }
}
