package Leetcode.Study.回溯.N皇后;

import java.util.Arrays;

class Solution2 {
    //2.复用N皇后代码
    public int totalNQueens1(int n) {
        Solution test = new Solution() {
        };
        return test.solveNQueens(n).size();
    }

    //2.count计数
    int n;
    int count = 0;

    public int totalNQueens2(int n) {
        this.n = n;
        //初始化棋盘,,"."代表空,"Q"代表皇后
        char[][] board = new char[n][n];
        for (char[] arr : board) {
            Arrays.fill(arr, '.');
        }
        //回溯,,从上到下放置皇后,因此从第0行开始,row=0
        backPath(board, 0);

        return count;
    }

    /**
     * 回溯算法
     *
     * @param board 棋盘
     * @param row   选择当前行是否要做选择,,放皇后
     */
    public void backPath(char[][] board, int row) {
        //回溯结束的条件是:每一行都成功放好了皇后,,记录此刻做出的选择,并将棋盘转化成list加入res
        if (row == board.length) {
            count++;
            return;
        }

        //在当前行的每一列都可能放置皇后,,但是需要检查这个位置是否能放置皇后
        for (int col = 0; col < n; col++) {
            //检查,,发现不能放,,就跳过排除当前位置
            if (!isValid(board, row, col)) {
                continue;
            }

            //回溯模板:
            //1.做出选择------这里也就是放置皇后
            board[row][col] = 'Q';
            //2.开始递归------放置第row+1行的皇后
            backPath(board, row + 1);
            //3.撤销选择
            board[row][col] = '.';
        }
    }

    /**
     * 检查函数
     *
     * @param board 棋盘
     * @param row   当前行
     * @param col   当前列
     * @return 是否能在当前棋盘的当前行和当前列 也就是board[row][col]放置皇后
     * 由于是顺序是"从上到下"放置皇后,并且每行只放一个
     * 因此放置皇后的时候只需要考虑当前行列的正上方,,左上方,,右上方
     */
    public boolean isValid(char[][] board, int row, int col) {
        //1.检查当前列的正上方是否已经有了皇后
        for (int i = 0; i < n; i++) {
            //如果由了皇后,那么当前位置就不可以放置皇后
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        //2.检查当前位置的左上有没有皇后
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        //3.检查当前位置的右上有没有皇后
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}