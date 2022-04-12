package Leetcode.Study.回溯.数独;

public class Solution36 {
    //参考37
    boolean[][] rowUsed = new boolean[9][10];
    boolean[][] colUsed = new boolean[9][10];
    boolean[][][] boxUsed = new boolean[3][3][10];

    public boolean isValidSudoku(char[][] board) {

        return isValid(board, 0, 0);
    }

    /**
     * 参考37
     *
     * @param board
     * @param row
     * @param col
     * @return 三个布尔类型数组分别记录当前行, 列, 3x3方格是否存在重复数字
     * 出现了就返回false
     * 否则就继续到下一列col+1,直到全部检测结束,返回true
     */
    public boolean isValid(char[][] board, int row, int col) {
        if (col == board.length) {
            col = 0;
            row++;
            if (row == board.length) {
                return true;
            }
        }
        if (board[row][col] != '.') {
            int num = board[row][col] - '0';
            if (!(rowUsed[row][num] || colUsed[col][num] || boxUsed[row / 3][col / 3][num])) {
                rowUsed[row][num] = true;
                colUsed[col][num] = true;
                boxUsed[row / 3][col / 3][num] = true;
                return isValid(board, row, col + 1);
            }
        } else {
            return isValid(board, row, col + 1);
        }
        return false;
    }
}
