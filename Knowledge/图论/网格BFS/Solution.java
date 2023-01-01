package LeetCode.知识点.图论.网格BFS;

import java.util.*;

public class Solution {
    /*1765*/
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;
        //初始化地图
        int[][] res = new int[m][n];
        //BFS所需要的队列
        Deque<int[]> queue = new ArrayDeque<>();
        //出队的次数
        int step = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //将水域作为起点,加入队列
                if (isWater[i][j] == 1) queue.addLast(new int[]{i, j});
                //初始化陆地为-1,水域在答案里
                res[i][j] = isWater[i][j] == 1 ? 0 : -1;
            }
        }
        //初始化高度
        int h = 1;
        //BFS方向
        int[] BFSdirections = new int[]{-1, 0, 1, 0, -1};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                int row = poll[0];
                int col = poll[1];


                /*开始BFS*/
                for (int j = 1; j < BFSdirections.length; j++) {
                    int nowRow = row + BFSdirections[j - 1];
                    int nowCol = col + BFSdirections[j];
                    //超出范围
                    if (nowRow >= m || nowCol >= n || nowRow < 0 || nowCol < 0) continue;
                    //已经访问过
                    if (res[nowRow][nowCol] != -1) continue;
                    //设置陆地高度
                    res[nowRow][nowCol] = h;
                    //入队
                    queue.addLast(new int[]{nowRow, nowCol});
                }
            }
            h++;
        }
        return res;
    }



    /*2146*/


    /**
     * TopK的问题:优先队列
     * 网格遍历:根据现实中也是BFS
     *
     * @param grid
     * @param pricing
     * @param start
     * @param k
     * @return
     */
    public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
        List<List<Integer>> res = new LinkedList<>();
        int r = grid.length;
        int c = grid[0].length;
        boolean[][] isVisited = new boolean[r][c];

        //优先级[step,price,row,col]
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(
                //越小优先级越高
                (int[] arr1, int[] arr2) -> {
                    if (arr1[0] != arr2[0]) return arr1[0] - arr2[0];
                    if (arr1[1] != arr2[1]) return arr1[1] - arr2[1];
                    if (arr1[2] != arr2[2]) return arr1[2] - arr2[2];
                    return arr1[3] - arr2[3];
                }
        );
        //用队列来处理BFS问题
        Deque<int[]> queue = new ArrayDeque<>();
        //初始化起始的地方
        queue.offer(start);
        isVisited[start[0]][start[1]] = true;

        //BFS的方向:分别是row+[i],col+[i+1]
        int[] bfsDirections = new int[]{-1, 0, 1, 0, -1};
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            /*BFS---队列出队,并让出队元素的相邻元素加入队列,等待下一次的出队*/
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                //出队得到当前位置
                int row = poll[0];
                int col = poll[1];
                //当前位置的price
                int price = grid[row][col];

                //无法穿越的墙'0'
                if (price == 0) continue;
                //感兴趣的物品,就加入优先队列
                if (price >= pricing[0] && price <= pricing[1]) {
                    priorityQueue.offer(new int[]{step, price, row, col});
                }

                /*开始BFS遍历*/
                for (int dir = 1; dir < bfsDirections.length; dir++) {
                    int nowRow = row + bfsDirections[dir - 1];
                    int nowCol = col + bfsDirections[dir];
                    //判断BFS是否已经访问过[nowRow,nowCol],并且一些位置是否合理
                    if (nowRow >= 0 && nowCol >= 0 && nowRow < r && nowCol < c && !isVisited[nowRow][nowCol]) {
                        queue.offer(new int[]{nowRow, nowCol});
                        isVisited[nowRow][nowCol] = true;
                    }
                }
            }

            //步数+1
            step++;
        }
        //通过优先队列获得TopK
        while (!priorityQueue.isEmpty() && res.size() < k) {
            int[] poll = priorityQueue.poll();
            res.add(Arrays.asList(poll[2], poll[3]));
        }
        return res;
    }
}
