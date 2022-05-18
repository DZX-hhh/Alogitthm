package LeetCode.学习计划.算法.Day8广度深度优先搜索;

public class DFS1091 {
    int res = Integer.MAX_VALUE, step = 0;

    public int shortestPathBinaryMatrix(int[][] grid) {
        dfs(grid, step, 0, 0);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private void dfs(int[][] grid, int step, int r, int c) {
        int n = grid.length;
        //跳出边界
        if (r < 0 || c < 0 || r >= n || c >= n) {
            return;
        }
        //访问过或者无法访问
        if (grid[r][c] != 0) {
            return;
        }
        //记录访问路径
        step++;
        grid[r][c] = 2;
        //到达顶点
        if (r == n - 1 && c == n - 1) {
            res = Math.min(res, step);//更新答案
        }
        //行列变换的8个方向
        int[] rowDir = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] colDir = {-1, 0, 1, -1, 1, -1, 0, 1};
        for (int i = 0; i < 8; i++) {
            dfs(grid, step, r + rowDir[i], c + colDir[i]);
        }
        step--;
        grid[r][c] = 0;
    }
}
