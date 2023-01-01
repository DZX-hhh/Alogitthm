package LeetCode.知识点.回溯.数独;

public class Solution37 {

    public void solveSudoku(char[][] board) {
        int n = board.length;
        //每一行是否存放某个数字
        boolean[][] rowUsed = new boolean[9][10];
        //每一列是否存放某个数字
        boolean[][] colUsed = new boolean[9][10];
        //每一个3x3宫格里是否存放某数字
        boolean[][][] boxUsed = new boolean[3][3][10];

        //初始化棋盘
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                int num = board[row][col] - '0';
                if (num <= 9 && num >= 1) {
                    rowUsed[row][num] = true;
                    colUsed[col][num] = true;
                    boxUsed[row / 3][col / 3][num] = true;
                }
            }
        }
        //从0行0列开始
        traverse(board, rowUsed, colUsed, boxUsed, 0, 0);
    }

    /**
     * 回溯函数:在为空的位置上,尝试放某个数字,如果不行,就回退
     *
     * @param board   棋盘
     * @param rowUsed 某一行是否存在某个数字
     * @param colUsed 某一列是否存在某个数字
     * @param boxUsed 某一个盒子是否存在某个数字
     * @param row     当前行
     * @param col     当前列
     * @return 当前棋盘是否能够放下棋盘
     */
    public boolean traverse(char[][] board, boolean[][] rowUsed, boolean[][] colUsed, boolean[][][] boxUsed, int row, int col) {
        //边界校验, 如果最后一行和最后一列都已经填充完成, 返回true, 表示一切结束
        if (col == board.length) {
            col = 0;
            row++;
            if (row == board.length) {
                return true;
            }
        }
        //看见空白位置,开始尝试
        if (board[row][col] == '.') {
            //每一个数字
            for (int num = 1; num <= 9; num++) {
                //行,列,3x3宫格都没出现num才为true
                boolean canUse = !(rowUsed[row][num] || colUsed[col][num] || boxUsed[row / 3][col / 3][num]);
                //如果某个数字可以尝试,那么就尝试
                if (canUse) {

                    rowUsed[row][num] = true;
                    colUsed[col][num] = true;
                    boxUsed[row / 3][col / 3][num] = true;

                    board[row][col] = (char) (num + '0');
                    //如果后面所有的数字都能够放下的话,就直接结束,,否则退回撤销对应的条件
                    if (traverse(board, rowUsed, colUsed, boxUsed, row, col + 1)) {
                        return true;
                    }

                    //撤销选择
                    rowUsed[row][num] = false;
                    colUsed[col][num] = false;
                    boxUsed[row / 3][col / 3][num] = false;
                    board[row][col] = '.';
                }
            }
        } else {
            return traverse(board, rowUsed, colUsed, boxUsed, row, col + 1);
        }
        return false;
    }
}