package 力扣.学习计划.算法.Day8广度深度优先搜索;

import java.util.Deque;
import java.util.LinkedList;

public class BFS1091 {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int res = 1;
        int n = grid.length;
        if (grid[0][0] != 0) {
            return -1;
        }
        if (n == 1) {
            return 1;
        }
        //行列变换的8个方向
        int[] rowDir = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] colDir = {-1, 0, 1, -1, 1, -1, 0, 1};
        Deque<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        grid[0][0] = 1;
        while (!queue.isEmpty()) {
            int k = queue.size();
            for (int i = 0; i < k; i++) {
                int[] poll = queue.poll();
                for (int j = 0; j < 8; j++) {
                    int newR = poll[0] + rowDir[j];
                    int newC = poll[1] + colDir[j];
                    //判断是否可行
                    if (newR >= 0 && newR < n && newC >= 0 && newC < n && grid[newR][newC] == 0) {
                        //判断是否到终点
                        if (newR == n - 1 && newC == n - 1) {
                            return ++res;
                        }
                        grid[newR][newC] = 1;//更新访问记录
                        queue.offer(new int[]{newR, newC});//入队
                    }
                }
            }
            res++;//这里将一层的所有元素都访问过了,res+1
        }
        return -1;
    }
}