package 力扣.学习计划.Top100.easy.Solution304;

/**
 * 求任意矩阵的和
 * 通过先弄出一个顶点都为原点开始计算的矩阵记录,然后再运算出来结果
 */
class NumMatrix {

    private int[][] preSum;

    public NumMatrix(int[][] matrix) {
        int prerow = matrix.length, precol = matrix[0].length;
        if (prerow == 0 || precol == 0) return;
        //构造前缀和矩阵
        for (int row = 1; row <= prerow; row++) {
            for (int col = 1; col <= precol; col++) {
                preSum[row][col] = preSum[row - 1][col]
                        + preSum[row][col - 1]
                        - preSum[row - 1][col - 1]
                        + matrix[row - 1][col - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return preSum[row2 + 1][col2 + 1] - preSum[row1 + 1][col2] - preSum[row1][col2 + 1] + preSum[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */