package LeetCode.学习计划.算法.Day11递归回溯;

public class Solution79 {
    public boolean exist(char[][] board, String word) {
        char[] wordArr = word.toCharArray();
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (dfs(board, wordArr, 0, r, c)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @param idx 字符当前索引
     * @param r   当前行
     * @param c   当前列
     */
    private boolean dfs(char[][] board, char[] wordArr, int idx, int r, int c) {
        //1.递归终止条件,,超出边界
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length) {
            return false;
        }
        //2.当前位置和字符数组不同,,就直接返回
        if (board[r][c] != wordArr[idx]) {
            return false;
        }
        //3.如果访问到了最后,返回true
        if (idx == wordArr.length - 1) {
            return true;
        }

        /*4.开始做出选择,让当前位置为空'\0'*/
        board[r][c] = '\0';

        //5开始递归dfs,,只要当前有一个选择可行,那就直接返回true
        if (dfs(board, wordArr, idx + 1, r, c + 1) ||
                dfs(board, wordArr, idx + 1, r, c - 1) ||
                dfs(board, wordArr, idx + 1, r + 1, c) ||
                dfs(board, wordArr, idx + 1, r - 1, c)
        ) {
            return true;
        }
        //5.撤销选择
        board[r][c] = wordArr[idx];

        return false;
    }
}
