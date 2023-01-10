package LeetCode.每日一题.Five.Day18;

public class Solution378 {
    /**
     * 与668相似,二分法,求左边界最小值
     *
     * @param matrix 有序矩阵
     * @return 第k小的元素
     */
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0], high = matrix[n - 1][n - 1];//开始二分
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (countLessK(matrix, n, mid) < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    /**
     * @param mid 当前值
     * @return 返回比mid小的个数
     * 这里从后往前遍历找到一个不比mid大的数,类似于左下角开始移动
     */
    private int countLessK(int[][] matrix, int n, int mid) {
        int r = n - 1, c = 0, count = 0;
        while (r >= 0 && c < n) {
            if (matrix[r][c] <= mid) {
                count += r + 1;//当前元素小于mid，则此函数及上方函数均小于mid
                c++;//往右移动
            } else {
                r--;//往上移动,直到找到<=mid的数字
            }
        }
        return count;
    }
}
