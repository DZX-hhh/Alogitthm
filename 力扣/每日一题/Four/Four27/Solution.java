package 力扣.每日一题.Four.Four27;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /*
        题意:找到能到Pacific和Atlantic都能到达的坐标
        -->反向思维:分别从Pacific和Atlantic出发dfs,记录分别能够到达的节点
        -->返回交叉的节点,也就是能够同时到达的节点
     */
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        int m = heights.length, n = heights[0].length;
        //分别记录两个海洋能够到的地方,记录为`1`
        int[][] Pacific = new int[m][n];
        int[][] Atlantic = new int[m][n];
        /*
            这里从四边海洋出发,dfs记录
         */
        //1.左右开始:行变换,列不变
        for (int i = 0; i < m; i++) {
            dfs(heights, Pacific, i, 0);
            dfs(heights, Atlantic, i, n - 1);
        }
        //2.上下开始:列变换,行不变
        for (int i = 0; i < n; i++) {
            dfs(heights, Pacific, 0, i);
            dfs(heights, Atlantic, m - 1, i);
        }
        //遍历每个点
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (Pacific[r][c] == 1 && Atlantic[r][c] == 1) {//如果记录交叉的地方,说明都能否到达
                    res.add(Arrays.asList(r, c));//记录答案
                }
            }
        }
        return res;
    }

    public static void dfs(int[][] heights, int[][] tmp, int r, int c) {
        //标记可以从海洋流回经过的节点
        tmp[r][c] = 1;
        //开始深度优先搜索当前坐标的4个方向
        //1. 设置更新的坐标
        int[] directions = {-1, 0, 1, 0, -1};
        //2. 更新坐标并递归搜索
        for (int index = 1; index < 5; index++) {
            int newR = r + directions[index - 1];
            int newC = c + directions[index];
            //判断下标是否越界
            if (newR < 0 || newC < 0 || newR >= heights.length || newC >= heights[0].length) {
                continue;
            }
            //判断能不能通过,这里`水往高处走`逆向思维,并且没有访问过
            if (heights[r][c] <= heights[newR][newC] && tmp[newR][newC] != 1) {
                dfs(heights, tmp, newR, newC);
            }
        }
    }
}