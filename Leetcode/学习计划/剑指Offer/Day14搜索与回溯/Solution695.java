package LeetCode.学习计划.剑指Offer.Day14搜索与回溯;

public class Solution695 {
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        int m = grid.length, n = grid[0].length;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                //dfs岛屿
                if (grid[r][c] == 1) {
                    int nowArea = dfs(grid, r, c);
                    res = Math.max(res, nowArea);
                }
            }
        }
        return res;
    }

    private int dfs(int[][] grid, int r, int c) {
        //1.跳出循环条件
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length) {
            return 0;
        }
        //岛且未访问
        if (grid[r][c] != 1) {
            return 0;
        }
        //修改访问状态
        grid[r][c] = 2;
        return dfs(grid, r - 1, c) +
                dfs(grid, r + 1, c) +
                dfs(grid, r, c - 1) +
                dfs(grid, r, c + 1) + 1;
    }
}
