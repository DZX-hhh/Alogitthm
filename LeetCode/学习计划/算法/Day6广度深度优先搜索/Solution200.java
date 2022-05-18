package LeetCode.学习计划.算法.Day6广度深度优先搜索;

public class Solution200 {
    public int numIslands(char[][] grid) {
        int res = 0;
        int m = grid.length, n = grid[0].length;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == '1') {
                    res++;
                    dfs(grid, r, c);
                }
            }
        }
        return res;
    }

    /**
     * 遍历标记grid[r][c]的周围的岛,构成一个群岛
     *
     * @param grid
     * @param r
     * @param c
     */
    private void dfs(char[][] grid, int r, int c) {
        //1.判断跳出递归条件
        if (r >= grid.length || r < 0 || c >= grid[0].length || c < 0) {
            return;
        }
        //2.已经访问过的,结束递归
        if (grid[r][c] != '1') {
            return;
        }
        //3.更改访问状态
        grid[r][c] = '2';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }
}
