package 力扣.WeekGame.Game70;

import java.util.*;

public class Solution {
    public int minimumCost(int[] cost) {
        if (cost.length == 1) return cost[0];
        if (cost.length == 2) return cost[0] + cost[1];
        Arrays.sort(cost);
        int res = 0;
        int i = 0;
        for (i = cost.length - 1; i >= 2; i -= 3) {
            res += cost[i] + cost[i - 1];
        }
        if (i == 1) res += cost[1] + cost[0];
        if (i == 0) res += cost[0];
        return res;
    }


    /**
     * 维护差分序列 前缀和 的最小值和最大值
     * 前缀和:n2-n1+n3-n2+...n   也就是n-n1  数组中任意一个元素-第一个元素
     *
     * @param differences
     * @param lower
     * @param upper
     * @return
     */
    public int numberOfArrays(int[] differences, int lower, int upper) {
        /**
         *数组任意一个元素∈[lower, upper]
         * 差分序列的前缀和=任意一个元素-first
         * first=任意一个元素-差分前缀和
         * 由于差分数组,确定了任何一个元素,都可以得出所有元素
         * 因此确定了first的范围也就是确定了   满足条件的隐藏数组  的总数
         *
         first + min ∈[lower, upper]
         first + max ∈[lower, upper]
         则first∈[lower - min, upper - max]
         那么个数就是upper - lower - (max - min) + 1   其中max和min是差分数组前缀和的最大值和最小值
         由公式可以，max - min该值与初始值没有关系， 不妨设初始值为0；
         但是个数成立的条件有
         1、upper-max>=lower-min,否则就为0,不存在
         */
        long preSum = 0;
        long min = 0;
        long max = 0;
        for (int diff : differences) {
            preSum += diff;
            max = Math.max(preSum, max);
            min = Math.min(preSum, min);
        }
        if (lower - min > upper - max) return 0;
        return (int) ((upper - max) - (lower - min) + 1);
    }

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

