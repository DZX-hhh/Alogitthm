package 力扣.周赛.Game292;

import 力扣.知识点.二叉树.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    /*
    T1
     */
    public String largestGoodInteger(String num) {
        for (int i = 9; i >= 0; i--) {
            String s = "" + i + i + i;
            if (num.contains(s)) {
                return s;
            }
        }
        return "";
    }


    /*
    T2
     */
    public int averageOfSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int res = 0;
        System.out.println(sum(root));
        System.out.println(count(root));
        System.out.println(sum(root) / count(root));
        if (root.val == sum(root) / count(root)) {
            res++;
        }
        return res + averageOfSubtree(root.left) + averageOfSubtree(root.right);
    }

    private int count(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + count(root.left) + count(root.right);
    }


    private int sum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }
        return root.val + sum(root.left) + sum(root.right);
    }

    /*
    T3
     */
    public int countTexts(String pressedKeys) {
        int[] dp = new int[pressedKeys.length() + 1];
        dp[0] = 1;
        for (int i = 0; i < pressedKeys.length(); i++) {
            //dp[i]=dp[i-1]+dp[i-2]+dp[i-3]
            //dp[i]=dp[i-1]+dp[i-2]+dp[i-3]+dp[i-4]
            for (int j = i; j >= 0 && j > i - ("79".contains("" + pressedKeys.charAt(i)) ? 4 : 3)
                    && pressedKeys.charAt(j) == pressedKeys.charAt(i); j--) {
                dp[i + 1] = (dp[i + 1] + dp[j]) % 1000000007;
            }
        }
        return dp[pressedKeys.length()];
    }

    /*
    T4
     */
    int m, n;
    char[][] grid;
    boolean[][][] visited;

    public boolean hasValidPath(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        if ((m + n) % 2 == 0 || grid[0][0] == ')' || grid[m - 1][n - 1] == '(') {
            return false; // 剪枝,长度为奇数的,第一个为')',或者最后一个为'('的,直接返回false
        }
        this.grid = grid;
        visited = new boolean[m][n][(m + n + 1) / 2];//(m+n+1)/2是路径中'('的个数
        return dfs(0, 0, 0);
    }

    /**
     * @param x 当前横坐标
     * @param y 当前纵坐标
     * @param c 当前路径中含有'('的个数
     * @return 当前坐标(x, y)的含'('状态c是否合法
     */
    private boolean dfs(int x, int y, int c) {
        //路径中含有'('的数量不够或者是超出仅剩下的(m-x+n-y)
        if (c < 0 || c > m - x + n - y - 1) {
            return false;
        }
        //终点一定是')',由于前面已经剪枝排除了终点为'('的情况,因此终点一定是')'
        if (x == m - 1 && y == n - 1) {
            //return c == 1;
            return true;
        }
        //已经访问过
        if (visited[x][y][c]) {
            return false;
        }
        //记录访问
        visited[x][y][c] = true;
        //更新路径中含'('的数目
        c += grid[x][y] == '(' ? 1 : -1;
        //向下或者向右,有一可行即可
        return (x < m - 1 && dfs(x + 1, y, c) || y < n - 1 && dfs(x, y + 1, c));
    }

    /*
        T4类似题:dfs+回溯--超时
        确定状态+疯狂剪枝
        这里boolean[x][y][c]
        x:当前横坐标
        y:当前纵坐标
        k:当前能够消减的个数
     */
    public int shortestPath(int[][] grid, int k) {
        int len = grid.length, col = grid[0].length;
        if (k >= len + col - 3) return len + col - 2;     //没有这句，超时
        boolean[][] visited = new boolean[len][col];  //避免dfs发生原路返回的情况
        int result = shortestPathDfs(grid, 0, 0, len, col, 0, k, visited);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public int shortestPathDfs(int[][] grid, int i, int j, int row, int col, int covered, int k, boolean[][] visited) {
        if (i < 0 || i >= row || j < 0 || j >= col) return Integer.MAX_VALUE; //递归出口
        if (i == row - 1 && j == col - 1) return covered;   //递归出口，结果
        if (visited[i][j]) return Integer.MAX_VALUE; //递归出口

        if (grid[i][j] == 1) {
            if (k > 0) k--;   //k做出牺牲，让1变为0
            else return Integer.MAX_VALUE; //k已经为0了，但是此块为1，则是一条死路
        }

        visited[i][j] = true;  //记录这条路径上这个节点已经访问过

        //取4个方向上可能路径的最小值返回
        int minOf4Dicrect = Integer.MAX_VALUE;
        minOf4Dicrect = Math.min(minOf4Dicrect, shortestPathDfs(grid, i - 1, j, row, col, covered + 1, k, visited));
        minOf4Dicrect = Math.min(minOf4Dicrect, shortestPathDfs(grid, i + 1, j, row, col, covered + 1, k, visited));
        minOf4Dicrect = Math.min(minOf4Dicrect, shortestPathDfs(grid, i, j + 1, row, col, covered + 1, k, visited));
        minOf4Dicrect = Math.min(minOf4Dicrect, shortestPathDfs(grid, i, j - 1, row, col, covered + 1, k, visited));

        visited[i][j] = false; //回溯
        return minOf4Dicrect;
    }

    /*
        由于求最短路径,因此bfs更适合
     */
    public int shortestPath2(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        //bfs所需要的队列
        Queue<int[]> queue = new LinkedList<>();
        //bfs的方向变化
        int[] directions = {-1, 0, 1, 0, -1};
        //状态从(0,0)开始,可以用于消除墙体的数量
        queue.offer(new int[]{0, 0, k});
        int[][] visited = new int[m][n];//这里为可用的k
        //初始化都为-1,未访问过
        for (int i = 0; i < m; i++) {
            Arrays.fill(visited[i], -1);
        }
        visited[0][0] = k;
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] poll = queue.poll();//此时数组为(x,y,k)
                int x = poll[0];
                int y = poll[1];
                int c = poll[2];
                //bfs到达终点,直接返回res即为最短路径
                if (x == m - 1 && y == n - 1) {
                    return res;
                }
                for (int i = 1; i < directions.length; i++) {//周围的坐标
                    //bfs遍历新坐标()
                    int newX = x + directions[i - 1];
                    int newY = y + directions[i];
                    //如果新坐标不合法,直接跳过
                    if (newX < 0 || newY < 0 || newX >= m || newY >= n) {
                        continue;
                    }
                    //判断是否为障碍物,如果是障碍物的话,c(可以消除的墙体个数)-1,反之不变
                    int newC = c + (grid[newX][newY] == 1 ? -1 : 0);
                    if (newC > visited[newX][newY]) {//如果还是未访问过的元素,那就
                        visited[newX][newY] = newC;//标记为当前状态
                        queue.offer(new int[]{newX, newY, newC});
                    }
                }
            }
            //每一圈循环,就代表着步数+1
            res++;
        }
        return -1;
    }
}

