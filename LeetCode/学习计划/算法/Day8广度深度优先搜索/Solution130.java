package LeetCode.学习计划.算法.Day8广度深度优先搜索;

public class Solution130 {
    /*
        1.将四周的'O'-->'-'
        2.遍历,将剩余的'O'转为'X'
        3.还原'-'-->'O'
     */
    public void solve(char[][] board) {
        //1.处理左右
        for (int i = 0; i < board.length; i++) {
            dfs(board, i, 0);
            dfs(board, i, board[0].length - 1);
        }
        //2.处理上下
        for (int i = 0; i < board[0].length; i++) {
            dfs(board, 0, i);
            dfs(board, board.length - 1, i);
        }
        //3.将内部的'O'-->'X'
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '-') {
                    board[i][j] = 'O';
                }
            }
        }
        return;
    }

    /**
     * 这里将'O'-->'-'
     */
    private void dfs(char[][] board, int r, int c) {
        int m = board.length, n = board[0].length;
        if (r < 0 || c < 0 || r >= m || c >= n || board[r][c] == 'X') {
            return;
        }
        if (board[r][c] == 'O') {
            //dfs周围的'O'-->'-'
            board[r][c] = '-';
            dfs(board, r - 1, c);
            dfs(board, r + 1, c);
            dfs(board, r, c - 1);
            dfs(board, r, c + 1);
        }
    }
}
